import os
import random
from datetime import datetime
from dotenv import load_dotenv
import google.generativeai as genai

# Load environment variables
load_dotenv()
genai.configure(api_key="AIzaSyAxAFp9504qR-_aSftG8sRsSQjEdHypf5s")

# List of random LeetCode problems (you can expand this list)
problems = [
    "Two Sum",
    "Reverse Linked List",
    "Valid Parentheses",
    "Merge Two Sorted Lists",
    "Longest Substring Without Repeating Characters",
    "Palindrome Number",
    "Remove Duplicates from Sorted Array",
    "Implement strStr()",
    "Search Insert Position",
    "Maximum Subarray"
]

# Select a random problem
problem = random.choice(problems)

# Generate solution using Gemini
def generate_solution(problem):
    try:
        model = genai.GenerativeModel('gemini-2.0-flash')
        prompt = f"Write a Java solution for the LeetCode problem: {problem}. Include the problem statement first, then the solution with the code block and the function signature and print the output for some test cases. Add comments to the code to explain the logic but make sure the code is clean and readable also add the time and space complexity of the solution and the reasoning behind it. also comment shouln't cause any issues with the code execution. filename should be the problem name in lowercase and replace spaces with underscores. and date should be the current date in the format YYYYMMDD added to the filename."
        response = model.generate_content(prompt)
        return response.text.strip()
    except Exception as e:
        print(f"An error occurred while generating the solution: {str(e)}")
        return None

# Save the solution in a Python file
def save_solution(solution, problem):
    filename = problem.lower().replace(" ", "_") + f"_{datetime.now().strftime('%Y%m%d')}.java"
    filepath = os.path.join("daily_solutions", filename)
    os.makedirs("daily_solutions", exist_ok=True)  # Ensure the directory exists
    with open(filepath, 'w') as f:
        f.write(f"# Problem: {problem}\n")
        f.write(solution)
    print(f"Solution for '{problem}' saved as '{filename}'.")

# Main execution
if __name__ == "__main__":
    solution = generate_solution(problem)
    if solution is None:
        print("Could not generate solution due to API error")
        exit(1)
    save_solution(solution, problem)
