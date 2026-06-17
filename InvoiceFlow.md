# InvoiceFlow

---

## Project goals

> InvoiceFlow is a software (desktop application) that helps writing invoices for companies.

**GUI**

> - Simple, minimalist design
> 
> - Color theme variations
> 
> - Easy-to-use and understand
> 
> - Shortcut keys
> 
> - Tooltip texts

**Working Principles**

> - Easy invoice creation
> 
> - Invoice schemes, (saving, importing)
> 
> - Exporting invoices as PDF files

## Implementation

- Modularity, expandability

- Simple code structure

Different modules should be:

- Theming

- GUI

- The root of the application (src)

IntelliJ IDEA structure is used.

## First focus: Theming

Separate module as previously described (named module). Only two classes should be visible outside: loader and some sort of container. Error handling is implemented as follows:

- If any error occurs during the theme file (json) reading or parsing, a default theme (already in java format) will be used.

**Logic and method of parsing**

- @First step: Read the raw json file -> throw Exception if file not found, do not handle 

- @Second step: Parse the json -> throw reading and parsing exceptions

- @Third step: Create java objects with crude data -> Validate crude data, fix possible errors

- Fourth step: Cache system -> To avoid recreation of paints etc. during the lifetime of the application
