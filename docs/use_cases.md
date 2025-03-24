# Розроблення функціональних вимог до системи

## Модель прецедентів

```plantuml
@startuml
actor Guest
actor User
actor Manager

usecase Registration
usecase "Activate(reactivate) Profile" as AP
usecase Login

usecase "Profile \nManagement" as PM
usecase "Create \nEntry Point" as CEP
usecase "Entry Point \nManagement" as EPM
usecase "Restore \nPassword" as RP

User -u-|> Guest
Manager -u-|> User

Guest -> Registration

User -u-> Login
User -l-> PM
User -> CEP
User --> AP
User --> RP

Manager -> EPM
@enduml

