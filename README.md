# **Tour Package Management Microservice**

## **Overview**
This is a Spring Boot application designed to manage a Tour Package Management Microservice. 
It demonstrates how to implement CRUD operations for tour and user.
The application is built with RESTful APIs.

## **Technology Stack**
        * Java 17
        * Spring Boot 3.x
        * Spring Data JPA
        * PostgreSQL
        * Swagger for API documentation
        * Lombok for cleaner code
## Tour Package Management Microservice API Documentation 
### **1. Create Tour Package**

        * Endpoint:
        POST /api/create-tour-package

        * Description:
        Creates a new tour package in the system.

        * Access Control:
        Requires ROLE_ADMIN authority.

        * Request Body (JSON)
        {
          "title": "string",
          "description": "string",
          "duration": "string",
          "location": "string",
          "image": "string",
          "discountInPercentage": 0,
          "actualPrice": 0,
          "discountedPrice": 0
        }
---------------------------------------------------------
        Response:
        * 201 Created
        * Body Example:
        {
          "message": "string"
        }

### **2. Get Tour Package by ID**
       * Endpoint: 
       GET /api/get-tour-package-by-id?id={id}

        * Description: Retrieves details of a specific tour package by its unique ID.

        * Access Control: Requires ROLE_SELLER authority.

        Query Parameter:
                * id (Long, required) — The ID of the tour package.

-------------------------------------------
        Response:
        * 200 OK
        * Body Example:      
        {
          "id": 0,
          "title": "string",
          "description": "string",
          "duration": "string",
          "location": "string",
          "image": "string",
          "discountInPercentage": 0,
          "actualPrice": 0,
          "discountedPrice": 0
        }

### **3. Get All Tour Packages**

        *  Endpoint: 
        GET /api/get-all-tour-packages
        
        * Description: Retrieves a list of all available tour packages in the system.
        
        * Access Control:Requires ROLE_SELLER authority.
        
        * Response:
                200 OK
                Body Example: 
                {
                    "id": 0,
                    "title": "string",
                    "description": "string",
                    "duration": "string",
                    "location": "string",
                    "image": "string",
                    "discountInPercentage": 0,
                    "actualPrice": 0,
                    "discountedPrice": 0
                }

### **4. Get Tour Package by Location**

       * Endpoint: 
       GET /api/get-tour-package-by-location?location={location}

       * Description: Retrieves a tour package available in a specific location.

       * Access Control: Requires ROLE_SELLER authority.

       * Query Parameter: location (String, required) — The location of the tour package.

       * Response:
       200 OK
       Body Example:
       {
              "id": 0,
              "title": "string",
              "description": "string",
              "duration": "string",
              "location": "string",
              "image": "string",
              "discountInPercentage": 0,
              "actualPrice": 0,
              "discountedPrice": 0
       }

# **Swagger UI Url**
**http://localhost:9090/swagger-ui/index.html#/**

# **Security Notes**
**ROLE_ADMIN ⇒ Can create tour packages.
ROLE_SELLER ⇒ Can view tour packages.
All endpoints require authentication via Spring Security.**
        
        
