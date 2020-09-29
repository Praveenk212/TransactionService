insert into transaction (transactionid,phnnumber,amttransfer,balance,dateoftransfer,amtreceived,receiveraccountnumber,senderaccountnumber,senderphnnumber,receiverphnnumber) values(1L,8288053865,1000,50000,TO_DATE('02/01/2020', 'DD/MM/YYYY'),0,100000000011,100000000013,8288053865,8955194111);
insert into transaction (transactionid,phnnumber,amttransfer,balance,dateoftransfer,amtreceived,receiveraccountnumber,senderaccountnumber,senderphnnumber,receiverphnnumber) values(2L,8955194111,0,50000,TO_DATE('02/01/2020', 'DD/MM/YYYY'),1000,100000000011,100000000013,8288053865,8955194111);
insert into transaction (transactionid,phnnumber,amttransfer,balance,dateoftransfer,amtreceived,receiveraccountnumber,senderaccountnumber,senderphnnumber,receiverphnnumber) values(3L,9782410575,0,50000,TO_DATE('02/06/2018', 'DD/MM/YYYY'),1000,100000000014,100000000012,9982828585,9782410575);
insert into transaction (transactionid,phnnumber,amttransfer,balance,dateoftransfer,amtreceived,receiveraccountnumber,senderaccountnumber,senderphnnumber,receiverphnnumber) values(4L,9782410575,1000,50000,TO_DATE('02/06/2018', 'DD/MM/YYYY'),0,100000000014,100000000012,9782410575,9982828585);



insert into account values(8288053865,100000000011,50000); 
insert into account values(9982828585,100000000014,50000); 
insert into account values(9782410575,100000000012,50000); 
insert into account values(8955194111,100000000013,30000);