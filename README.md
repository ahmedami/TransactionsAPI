# TransactionsAPI
  Web API for Transaction.

## Architecture
![alt tag](https://github.com/ahmedami/TransactionsAPI/blob/master/Architecture.png)

### DataBase Layer
Since There is no Database this layer insteadeof Database it more like cache but for sake of simplicity lets deal with it as dataBase.
####DataStructrue
Here i influenced by Graph and specificly adjacency list representation, However i used Hash to store those objects.
![alt tag](https://github.com/ahmedami/TransactionsAPI/blob/master/datastructure.png)
    
### DAO Layer
This Layer to make a CRUD operation on Entity

###Service Layer
It containing Transaction that hold every transaction with DAO Layer.

###Facade Layer 
Every method from it may use many methods from Service Layer , it's for simplicity.

###DTO
Containing Dtos that we transfer to and from client.

###Entity
Contain the object that will presist to DataBase  .

###Exception
It's a custom Exception to keep exception handling as simple as possible.


##How To Run
Its a Maven Project Just import and deploy it .
  ####Note 
    'v1' which in the URI just for sake of versioning .
    
- PUT transactionservice/v1/transactions/${transactionId}
  body example { "amount": 600, "type":"cars" ,"parentId":"1"}
  create a new Transaction
  
- GET transactionservice/v1/transactions/${transactionId}
  it get All information about a certain Transaction
  
- GET /transactionservice/v1/types/${typeName}
  it get All transactions Ids associated to certain Type

- GET /transactionservice/v1/sum/${transactionId}
  A sum of all transactions that are transitively linked by their parent_id to $transaction_id.
- go to GoEuroApp folder.
-  type that command from you terminal ' java -jar GoEuroApp.jar "placeName" '.
