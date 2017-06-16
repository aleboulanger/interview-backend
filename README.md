Quick Introduction
==================

Aim of the Interview 
---------------------

The interview aim is to check your ability to :
* to validate a pull request (PR)
* to implement a new feature

We will also look at how you are used to work.


Presentation of the project
===========================

The project is composed of 2 main components:
- the phone-inventory
- the phone-market

The Phone Inventory
-------------------
This is a component that is handling the phones that the company is selling.
For now, there is no notion of price.


The Phone Market
----------------
The company recently subscribe a service from an external company that is able to
retrieve prices from several sources (competitors) and calculate a competitive 
price for a phone.

This component is just a mock of this service and provide the same interface.


What we want you to do
-----------------------

Your colleague just finish the mock (The phone market project) and is now in holiday.
You are in charge of integrating the dynamic price in the inventory component.
For the demo, the inventory should call the mock and show the updated prices.