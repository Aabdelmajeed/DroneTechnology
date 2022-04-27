# **Drone Technology**


### **Intro**
---
- There is a major new technology that is destined to be a disruptive force in the
field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone
has the potential to leapfrog traditional transportation infrastructure.


### - **What's used in project**
---

| what's used   |    advantage    | 
|----------|:-------------:|
| H2 in-memory database|  persist data in db |
| javax-Validation |    in entity Validation   |   
| modelmapper | mapping object to other |   
| Lombok | remove a poilerplate code also provide builder pattern for object using **@Builder** |   
| modelmapper | mapping object to other |   


### - **Database Tables and RelationShip between them**
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
     
     
