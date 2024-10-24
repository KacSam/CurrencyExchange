# CurrencyExchange

## Overview

The **CurrencyExchange** project is a small object-oriented programming (OOP) application developed as part of a university assignment. It simulates a currency exchange system where users can view exchange rates and perform currency conversions between different international currencies.

The project demonstrates the application of OOP principles such as **encapsulation**, **inheritance**, **polymorphism**, and **abstraction**, while interacting with external APIs to fetch real-time currency data.

## Features

- **Fetch Real-Time Exchange Rates**: Retrieves the latest currency rates using the [NBP API](https://api.nbp.pl/).
- **Currency Conversion**: Allows users to convert an amount from one currency to another based on current exchange rates.
- **User-Friendly Interface**: A simple console-based UI for ease of interaction.
- **Error Handling**: Handles invalid inputs, such as incorrect currency codes or invalid amounts.
- **OOP Principles**: The project follows object-oriented design, with classes for handling currencies, exchange operations, and API data parsing.

## Project Structure

- **Currency**: Represents a currency with attributes like name, code, and exchange rate.
- **Exchanger**: The core logic for converting one currency to another.
- **CurrencyCollection**: Holds a collection of available currencies.
- **DataProvider**: Handles fetching data from the NBP API.
- **Parser**: Parses the XML data fetched from the API and populates the currency collection.
- **CurrencyUI**: Provides a console-based user interface for interacting with the system.
