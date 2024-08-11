
# PointOfSaleSystem

Welcome to the **PointOfSaleSystem**! This system is designed to manage sales, inventory, and customer transactions seamlessly, similar to popular POS systems like Square. This README will guide you through setting up the project, understanding its core features, and exploring the available APIs.

## Table of Contents

- [Getting Started](#getting-started)
- [Features](#features)
- [APIs](#apis)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- Java 11
- Maven or Gradle
- MySQL or any other RDBMS

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/rishabh-agarwal/PointOfSaleSystem.git
    cd PointOfSaleSystem
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Set up the database:

    ```sql
    CREATE DATABASE pos_system;
    ```

4. Run the application:

    ```bash
    java -jar target/PointOfSaleSystem.jar
    ```

### Configuration

Configure your database and other environment variables in the `application.properties` file located in the `src/main/resources` directory.

## Features

- **Inventory Management**: Track product quantities, manage stock levels, and set reorder points.
- **Sales Transactions**: Process sales, returns, and exchanges efficiently.
- **Customer Management**: Store customer information and purchase history.
- **Reporting**: Generate sales and inventory reports.
- **User Management**: Handle different roles and permissions within the system.

## APIs

Below is a list of basic APIs available in the PointOfSaleSystem:

### 1. Product API

- **Get All Products**
  - **Endpoint**: `/api/products`
  - **Method**: `GET`
  - **Description**: Retrieves a list of all available products.
  
- **Get Product by ID**
  - **Endpoint**: `/api/products/{id}`
  - **Method**: `GET`
  - **Description**: Retrieves details of a specific product by its ID.
  
- **Create New Product**
  - **Endpoint**: `/api/products`
  - **Method**: `POST`
  - **Description**: Adds a new product to the inventory.
  
- **Update Product**
  - **Endpoint**: `/api/products/{id}`
  - **Method**: `PUT`
  - **Description**: Updates the details of an existing product.
  
- **Delete Product**
  - **Endpoint**: `/api/products/{id}`
  - **Method**: `DELETE`
  - **Description**: Deletes a product from the inventory.

### 2. Sales API

- **Create Sale**
  - **Endpoint**: `/api/sales`
  - **Method**: `POST`
  - **Description**: Processes a new sale transaction.

- **Get Sale by ID**
  - **Endpoint**: `/api/sales/{id}`
  - **Method**: `GET`
  - **Description**: Retrieves details of a specific sale transaction by its ID.

- **Get All Sales**
  - **Endpoint**: `/api/sales`
  - **Method**: `GET`
  - **Description**: Retrieves a list of all sales transactions.

### 3. Customer API

- **Get All Customers**
  - **Endpoint**: `/api/customers`
  - **Method**: `GET`
  - **Description**: Retrieves a list of all customers.
  
- **Get Customer by ID**
  - **Endpoint**: `/api/customers/{id}`
  - **Method**: `GET`
  - **Description**: Retrieves details of a specific customer by their ID.
  
- **Create New Customer**
  - **Endpoint**: `/api/customers`
  - **Method**: `POST`
  - **Description**: Adds a new customer to the system.
  
- **Update Customer**
  - **Endpoint**: `/api/customers/{id}`
  - **Method**: `PUT`
  - **Description**: Updates the details of an existing customer.
  
- **Delete Customer**
  - **Endpoint**: `/api/customers/{id}`
  - **Method**: `DELETE`
  - **Description**: Deletes a customer from the system.

### 4. Inventory API

- **Get Inventory Levels**
  - **Endpoint**: `/api/inventory`
  - **Method**: `GET`
  - **Description**: Retrieves current inventory levels for all products.
  
- **Update Inventory**
  - **Endpoint**: `/api/inventory/{productId}`
  - **Method**: `PUT`
  - **Description**: Updates the inventory level of a specific product.

## Contributing

Contributions are welcome! Please fork this repository, create a new branch for your feature or bugfix, and submit a pull request.

### Steps to Contribute

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch-name`
3. Make your changes and commit them: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature-branch-name`
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
