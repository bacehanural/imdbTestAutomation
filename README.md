# IMDb Test Automation Project

## Summary of Technologies Used
SDL: Java

Automation: Selenium WebDriver

Testing Framework: TestNG


## Project Approach
The project aimed to automate the verification of film (Betty Blue) information on IMDb using Java with Selenium WebDriver for automation. TestNG was chosen as the testing framework for its flexibility and robustness.

## Test Case Overview
The test case focused on verifying the consistency of "Director", "Writer", and "Stars" information for a film accessed through two access methods: via the Oscars section and direct search.

## Test Steps
1. The test navigates to the IMDb page.
2. Click on the hamburger menu from the Global Header called “Menu.”
3. Click the “Oscars” link under the “Awards & Events” category list.
4. Click “1980s” under the “Event History” section.
5. Click “1987” from the “1980s” tab.
6. Click on "Betty Blue” from the "Best Foreign Language Film" category.
7. Record the name of the Director (1 Director -> director), Writers (2 Writers -> writer1 & writer2), and Stars (3 Stars -> star1 & star2 & star3) of "Betty Blue” from the relevant webpage.
8. Redirect to the Homepage by clicking on the “IMDb” logo from the Global Header.
9. Type "Betty Blue” into the search box component.
10. Perform a direct search for "Betty Blue” on the search box component.
11. Click on the "Betty Blue” from the search results.
12. Record the name of the Director (1 Director -> directorSearchPage), Writers (2 Writers -> writer1SearchPage & writer2SearchPage), and Stars (3 Stars -> star1SearchPage & star2SearchPage & star3SearchPage) of "Betty Blue” from the redirected webpage.
13. Details obtained from both access methods are compared to ensure consistency.


## Challenges Encountered
	✓	The "CSS Selectors" and "Xpaths" on the website were poorly prepared, causing significant time loss. Even when I tried to prepare the relevant paths in a manner befitting a professional and validated their accuracy numerous times, I would still randomly encounter "path not found" errors within the code (twice out of 10 runs of the same code). Consequently, I had to write the paths in a manner that did not reflect my professionalism and experience. Furthermore, I had to insert pauses into the code to handle these randomly occurring errors.
	✓	Due to the assignment comprising a single automated test case and the absence of such a requirement, I chose not to use the Page Object Model (POM) structure. Despite my efforts to minimize repetition in the code, unfortunately, I could not eliminate it.
	✓	I have actively used Selenium for 13 years, and I genuinely appreciate Object-Oriented Programming Languages; however, as a Test Developer, scripting languages and the flexible structures of their supported Testing Frameworks could be a preferable option due to their abundance of options for compatibility, and ease of use, especially as they have become increasingly influential in recent years.
