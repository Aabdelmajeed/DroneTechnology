# **Drone Technology**

# **Table Of Content**
---
    - How to Run Project Locally and Test it using postman.
    - How to use PostMan and import collections.
    - How to H2-database records either dummy records or records added when using apis it will help in testing the api.
    - Introduction of what Drone Technology is.
    - what's used in project and how it facilities our development.
    - High level design of database and Entity Releationship between our tables.
    - API Endpoints what's the meaning and how to use it.
    - Regarding Schedule task for checking battery levels for drones.

### **How to run project Locally**
---
- Download the project extract it and import it to any IDE like (Intellij).
- Run the project it will run on port 8085 `(now our drone service is up and running on port 8085 it's time to test it)`
- You can use postman collection to test the apis. `below how to use postman and import collections`

### **How to use PostMan and import collections**
---
- In folder `postman` I attached the collection Just/
     1) open postman
     2) click on import button
     3)  import it as shown below
 <p align="left">
   <img src="https://user-images.githubusercontent.com/88937645/165634426-732416c4-0d62-46ba-97fe-18a37d954aff.PNG" width="700" height ="450"> 
 <p>

- After importing it there's collection for all apis task has as shown below.
  <p align="left">
   <img src="https://user-images.githubusercontent.com/88937645/165635042-2592cf13-86da-48c5-9b75-bf62a1759d5c.PNG" width="700" height ="450"> 
 <p>
     
### **How to show H2-database tables and record**  `will be helpful when testing the apis`
---
- in the browser and after running the service just write in the browser the following URL `http://localhost:8085/h2-console`
- it will open a window as shown below make sure that JDBC URL is the following `jdbc:h2:mem:drone`
 <p align="left">
   <img src="https://user-images.githubusercontent.com/88937645/165636365-2dbb0af9-7879-4474-8163-f67371012668.PNG" width="700" height ="450"> 
 <p>
  
 - you can use the below queries to show all records in Drone Table or Medication Table\
     `SELECT * FROM DRONE `\
     `SELECT * FROM MEDICATION ` 
    
     
### **Introduction of what Drone Technology is**
---
    - There is a major new technology that is destined to be a disruptive force in the
    field of transportation: the drone.
    Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone
    has the potential to leapfrog traditional transportation infrastructure.


### - **what's used in project and how it facilities our development**
---

| what's used   |    advantage    | 
|----------|:-------------:|
| H2 in-memory database|  persist data in db |
| javax-Validation |    in entity Validation   |   
| modelmapper | mapping object to other |   
| Lombok | remove a poilerplate code also provide builder pattern for object using **@Builder** |   
| modelmapper | mapping object to other |   

     

### - **High level design of database and Entity Releationship between our tables**
---
    - Relationship: one To Many
    
 **Entity Relationship**
 <p align="center">
   <img src="https://user-images.githubusercontent.com/88937645/165602994-46612181-b379-40b6-812d-7488a0df4f89.PNG"> 
 <p>
 
   > each Drone can Hold more than one medication based on his weight ability.

### - **API EndPoints**  `you can import postman collection in postman Folder and try it yourself`
---
     
  - `POST` **/drone/register**
      - used to register a new Drone
      - Body Request Example
     
          **{\
                "serialNumber":"11111",\
                "weightLimit":"50",\
                "droneModel": "MIDDLEWEIGHT",\
                "batteryCapacity": 25.5,\
                "droneState":"IDLE"\
          }**
   
     
  - `GET` **/drone/available**
      - Get All Available Drones To load Medications
      - it will get All Drones that are in either `Idle` or `Loading` state but their `battery` greater than 25%
   
  - `GET` **/drone/{{droneSerialNumber}}/getLoadedMedicationItem**
      - api used to get all medication Item that's loaded by Drone with given drone serial number.      
   
  - `GET` **/drone/{{droneSerialNumber}}/batteryLevel**
      - api used to get the battery level for given drone's serial number.
   
     
  - `POST` **/drone/{{droneSerialNumber}}/loadMedications**
      - api used to load medication to given drone's serial number.
      - in order to load a medication drone must be available (IDLE / Loading) state and has the ability to load these weight of medications.
     
     
### **Regarding Schedule task for checking battery levels for drones.**
---
     - scheduale task is done to check the battery sizes for the drones and log it in a file as shown below.
     - it will log all drones serial number and their battery level in that convension `[serialNumber:batteryLevel]`.
     - task period is 5 sec I also make it configurable in application.porperties

<p align="center">
   <img src="https://user-images.githubusercontent.com/88937645/165651672-92fdbbf8-39f9-4725-a296-5fbc022000b3.PNG"> 
 <p>
     
  
