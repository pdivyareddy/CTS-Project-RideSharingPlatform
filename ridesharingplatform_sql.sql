create database ridesharingplatform;

use ridesharingplatform;

show tables;

select * from vehicles;

select * from vehicledetails;

select * from vehicletypes;

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
VALUES(1001, 'Point A', 'Point B', '2023-10-05', '23:00:00','20', 'APO4123451',  2001, 2);

select * from incidents;

select * from incident_types;

select * from investigation_details;

select * from companies;

select * from drivinglicenses;

select * from userapplication;