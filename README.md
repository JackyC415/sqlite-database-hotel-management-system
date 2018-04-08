# Database-Hotel-Management

Database application is implemented with JDBC; Eclipse Neon and SQLiteStudio.

Database Application Description:
Application is capable of reserving rooms for incoming guests, extracting multiple tables with data; such as Employee, Department, Guest info etc.. , updating room/checkstatus, and removing guests information upon checkout.

Use Case Description:
Hotel managers have access to login administration.
New Customer Form (Reception) for new guests reservations.
User is able to request data from the following tables: Employee, Department, ManagerInfo, Room, and CustomerInfo.
User is able to search for room and the pick up service.

Relational Database Schema:
Checkstatus(c_guestid, c_roomid, c_checkstatus, c_date, c_time, c_paymentstatus)
Department(d_id, d_name, d_managerid, d_budget)
Driver(dr_id, dr_age, dr_name, dr_gender, dr_style)
Employee(e_employeeid, e_departmentid, e_salary, e_job, e_name, e_department)
Guest(g_id, g_name, g_gender, g_countryname, g_roomReserved, g_checkstatus, g_depotsit)
Manager(m_id, m_name, m_salary, m_age, m_gender, m_departmentID)
PickUpCar(p_id, p_year, p_brand, p_driverid, p_availability, p_airport)
Room(r_id, r_checkstatus, r_cleanstatus, r_price, r_bedtype, r_roomNumber, r_guestid)
Many to Many Relationships: Room with Guest and Manager with Department.
