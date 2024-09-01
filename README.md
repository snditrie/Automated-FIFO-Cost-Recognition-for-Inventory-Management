# FIFO Inventory Cost Calculation Service

This project is a service designed to calculate and assign costs to inventory mutations (outflows) based on the FIFO (First In, First Out) method. It automates the process of determining the cost for items that leave inventory, ensuring that the earliest received inventory is used first for cost calculation.

## Features
- Automated Cost Calculation: Calculates the cost for each inventory outflow (mutasi) based on the FIFO method.
- FIFO Compliance: Ensures that costs are deducted starting from the oldest inventory, aligning with FIFO accounting standards.
- Inventory Management: Updates the available inventory after each cost calculation to maintain accurate records.

## Technologies Used
- Java 17
- Spring Boot
- Lombok
- JPA/Hibernate
- PostgreSQL

## How It Works
The MutasiService class is responsible for calculating the cost associated with each Mutasi (inventory outflow). The service works as follows:
1. **Fetch Available Inventory**: Retrieves the available inventory records from the FIFO table using the FifoService.
2. **Calculate Total Cost**: Iterates through the FIFO inventory to calculate the total cost based on the quantity needed for the mutation.
3. **Update Inventory**: Deducts the used quantity from the FIFO inventory and updates the records accordingly.
4. **Set Cost**: Assigns the calculated cost to the Mutasi entity.
5. **Save Mutation**: Saves the updated Mutasi record, including the calculated cost, to the database.

## Installation
### Clone the repository:
    git clone https://github.com/snditrie/Automated-FIFO-Cost-Recognition-for-Inventory-Management
    cd Automated-FIFO-Cost-Recognition-for-Inventory-Management

### Setup the Database:
- Create a database in PostgreSQL.
- Update the application.properties file with your database connection details.

### Build the Project:
- If you are using Maven, run the following command to build the project:
  ```bash
  mvn clean package
  ```
### Run the Application:
- Run the application directly from your IDE (e.g., Eclipse, IntelliJ) or use Maven to start it:
  ```bash
  mvn spring-boot:run
  ```
