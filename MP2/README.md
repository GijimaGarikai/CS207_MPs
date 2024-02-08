# Calculator Project

This project provides a set of Java classes that collectively form a calculator application capable of handling basic arithmetic operations on fractions and whole numbers. The project consists of the following classes:

- `BigFraction`: A class representing fractions with enhanced precision using `BigInteger` for numerator and denominator.
- `BFCalculator`: A class implementing a BigFraction Calculator capable of performing arithmetic operations on fractions.
- `InteractiveCalculator`: A class implementing an Interactive Calculator that allows users to perform calculations via the command-line interface (CLI).
- `QuickCalculator`: A class implementing a Quick Calculator that efficiently computes multiple arithmetic expressions provided as command-line arguments.
- `Registers`: A class representing registers to store past result values of the Quick or Interactive calculators.

## Purpose

The purpose of this calculator project is to provide users with a flexible and interactive tool for performing arithmetic calculations involving fractions and whole numbers. The project aims to offer different modes of interaction, including interactive CLI usage and quick computation of multiple expressions from command-line arguments.

## Authors

- Garikai Gijima
- Samuel A. Rebelsky (ideas were taken from the instructions)

## Class Overview

### `BigFraction`

- Represents fractions with enhanced precision using `BigInteger`.
- Supports arithmetic operations such as addition, subtraction, multiplication, and division.
- Provides methods for simplifying fractions and converting them to double or string representation.

### `BFCalculator`

- Implements a BigFraction Calculator for performing arithmetic operations on fractions.
- Stores the last computed result and allows addition, subtraction, multiplication, and division with fractions.
- Supports storing and retrieving values from registers.

### `InteractiveCalculator`

- Implements an Interactive Calculator for performing calculations via the command-line interface (CLI).
- Allows users to enter space-separated expressions and performs calculations interactively.
- Provides instructions on valid input formats and operators.

### `QuickCalculator`

- Implements a Quick Calculator for efficiently computing multiple arithmetic expressions provided as command-line arguments.
- Processes each expression and outputs the result along with the expression itself.
- Handles error cases and displays appropriate error messages for invalid expressions.

### `Registers`

- Represents registers to store past result values of the Quick or Interactive calculators.
- Supports storing and retrieving BigFraction values identified by letters from 'a' to 'z'.

## Usage

1. Compile the Java files.
2. Run the desired calculator class based on the preferred mode of interaction:
   - For interactive calculations, run `InteractiveCalculator`.
   - For quick computations of multiple expressions, run `QuickCalculator` with expressions as command-line arguments.

## Error Handling

- The calculators handle invalid expressions gracefully and display appropriate error messages.
- Error messages guide users on correcting input errors and provide instructions on valid input formats.

