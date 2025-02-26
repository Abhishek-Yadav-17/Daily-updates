# Write a python script that takes the branch name of gihub then compare that branch with the main branch and if the branch is not up to date with the main branch, then it will be merged with the main branch and comapre the branch with the main branch again and give documentation of the changes also if there is scope of improvement in the code then it will be suggested to the user in the documentation. If there is some conflict then the merging process should terminate and the user should be asked to resolve the conflict manually also share the code of the branch and the main branch where the conflict is.

import subprocess
import requests
import datetime
import os
from dotenv import load_dotenv
import google.generativeai as genai

# Load environment variables
load_dotenv()
genai.configure(api_key="AIzaSyAxAFp9504qR-_aSftG8sRsSQjEdHypf5s")

GIT_TOKEN = os.getenv("GIT_TOKEN")

def run_command(command):
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    if result.returncode != 0:
        raise Exception(f"Command failed: {result.stderr}")
    return result.stdout

def analyze_with_llm(diff):
    try:
        model = genai.GenerativeModel('gemini-2.0-flash')
        prompt = f"Analyze the following code differences and provide a summary: {diff}"
        response = model.generate_content(prompt)
        return response.text.strip()
    except Exception as e:
        raise Exception(f"An error occurred while analyzing with LLM: {str(e)}")

def create_simple_documentation(analysis):
    doc = "Hey there! Let's see what happened with our code:\n\n"
    doc += f"1. **What's Different?**\n   - Our code had some changes: {analysis}. Imagine your toy car got new wheels!\n\n"
    doc += "2. **What Did We Do?**\n   - We tried to mix our new toy car with the old one. Sometimes, they fit perfectly!\n\n"
    doc += "3. **Oops, a Problem!**\n   - If the toys didn't fit, we need to fix them. It's like when your blocks don't stack right.\n\n"
    doc += "4. **All Done!**\n   - Now, our toy car is super cool with all the new parts!\n\n"
    doc += "Remember, fixing things is like solving a fun puzzle!"
    return doc

def write_documentation_to_file(documentation):
    filename = f"documentation_{datetime.datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
    with open(filename, 'w') as file:
        file.write(documentation)
    print(f"Documentation written to {filename}")

def compare_and_merge(branch_name):
    try:
        run_command("git fetch origin")
        run_command(f"git checkout {branch_name}")
        diff = run_command("git diff origin/main")

        if diff:
            analysis = analyze_with_llm(diff)
            print("LLM Analysis of differences:")
            print(analysis)

            try:
                run_command("git merge origin/main")
                print("Branch merged successfully.")
            except Exception as e:
                print("Merge conflict detected. Please resolve manually.")
                conflict_analysis = analyze_with_llm("Conflict detected")
                print("LLM Analysis of conflict:")
                print(conflict_analysis)
                return

            new_diff = run_command("git diff origin/main")
            if new_diff:
                print("Changes after merge:")
                print(new_diff)
                post_merge_analysis = analyze_with_llm(new_diff)
                print("LLM Post-merge analysis:")
                print(post_merge_analysis)
                simple_doc = create_simple_documentation(post_merge_analysis)
                write_documentation_to_file(simple_doc)
        else:
            print("Branch is up to date with the main branch.")

    except Exception as e:
        print(f"An error occurred: {e}")

# Example usage
branch_name = "feature-branch"
compare_and_merge(branch_name)