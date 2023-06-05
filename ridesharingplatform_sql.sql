create database ridesharingplatform;

use ridesharingplatform;

show tables;

select * from vehicles;

select * from vehicledetails;

select * from vehicletypes;

insert into vehicletypes values 
(1, 10, 4, 'suv'), (2, 15, 4, 'sedan'), (3, 8, 1, '2 wheeler'), (4, 13, 3, 'jeep'), (5, 20, 6, '7 wheeler');

select * from bookings;

INSERT INTO bookings(bookingid, bookedon, rideruserid, noofseats, totalamount, 
paymentmode, ridescheduleid)
VALUES
(1, 1632345600, 2001, 2, 40, 'Credit Card', 1001),
(2, 1632432000, 2002, 1, 20, 'PayPal',1002),
(3, 1632518400, 2003, 1, 30, 'Debit Card', 1003),
(4, 1632518400, 2003, 2, 30, 'Debit Card', 1004),
(5, 1632518400, 2003, 2, 30, 'Debit Card', 1005);

select * from distances;

INSERT INTO distances (distanceid, distancefrom, distanceto, distancesinkms)
VALUES 
    (1001, 'Point A', 'Point B', 5),
    (1002, 'Point A', 'Point C', 3),
    (1003, 'Point B', 'Point C', 2),
    (1004, 'Point B', 'Point D', 7),
    (1005, 'Point C', 'Point D', 4);

select * from rideschedules;

INSERT INTO rideschedules(id, ridefrom, rideto,ridestartson, ridetime, ridefare,
vehicleregistrationno, motoristuserid, noofseatsavailable)
VALUES(1001, 'Point A', 'Point B', '2023-10-05', '23:00:00','20', 'AP27CZ1568',  2001, 2);

select * from incidents;

select * from incident_types;

select * from investigation_details;

select * from companies;

INSERT INTO COMPANIES(Id,Company_Name,Building_Name,Security_Incharge_Name,Security_Help_Desk_Number)
VALUES ('12345','ABC','12','RAJ','9000000000');

select * from drivinglicenses;

INSERT INTO DRIVINGLICENSES(Id,User_Id,License_No,Expiration_Date,RTA,Allowed_Vehicles)
VALUES('12345','1234567890','12300','2023-12-19','RTA','BIKE');

select * from userapplication;

INSERT INTO USERAPPLICATION(User_Id,User_name,Official_Email,Phone_Number,Company_Id,
Designation,Role,Employee_Id,Aadhar_Number,Application_Status)
VALUES('1234567890','JAGGU','ABC@GMAIL.COM','9876454013','12345','MANAGER','MOTORIST','2263003','123456789012','APPROVED');
