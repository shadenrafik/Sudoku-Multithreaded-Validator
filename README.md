# Sudoku Multithreaded Validator

A high-performance concurrency tool designed to validate 9x9 Sudoku solution boards. This project demonstrates the efficiency of parallel processing by splitting validation tasks across multiple threads.

## Technical Overview
### System Architecture
This application moves beyond simple sequential processing by implementing a multithreaded worker model.
* **Language:** Java (utilizing `java.lang.Thread` and `Runnable` interfaces).
* **Input Handling:** robust CSV parsing logic to read Sudoku board configurations from external files.
* **Synchronization:** Ensures thread safety when multiple workers report validation results to the main application process.

### Functional Specifications
#### 1. Parallel Validation Logic
Instead of checking the board one cell at a time, the system spawns dedicated worker threads to validate different constraints simultaneously:
* **Row Validation:** Verifies that every row contains unique digits (1-9).
* **Column Validation:** Verifies that every column contains unique digits.
* **Sub-grid (Box) Validation:** Verifies that each of the nine 3x3 sub-grids is valid.

#### 2. Error Detection & Reporting
* **Granular Feedback:** The system does not just return "False" for invalid boards; it identifies the specific region that failed validation (e.g., "Invalid Row 4" or "Duplicate in Box 7").
* **State Management:** The main thread aggregates results from all workers to determine the final validity state of the board.

## Contributors
* Mohamed Bahig
* Sara Hany
* Hayat Tarek
* Shaden Rafik
