# E-Wallet Application

E-Wallet Application is an electronic-wallet application that if a user has one account, the user can have multiple e-wallet accounts. In the electronic wallet application, the user can top-up or make a deposit to the electronic wallet and the user can make a withdrawal or the user can make a cash withdrawal if the user has a balance in the electronic wallet.

### Prerequites
#### Software Utility
* Oracle JDK 1.8
* Maven
* PostgreSQL
#### Dependencies
* PostgreSQL Driver
* Spring Data JPA
* Spring Web
* Spring Starter Security
#### Operating System
* Ubuntu 20.04

#### Installing
* Open https://start.spring.io/
* Fill in the fields as needed
* Add dependencies
* Click generate and it will be downloaded in the form of a zip
* Extract the downloaded zip file
* Open the extracted file on Intellij IDEA
* Use the package manager maven to install and build Shopaa app.

## API
### Account
In the account section, users can do register account, sign-in account, update account, see information account, and delete account.
#### Register account
This is the first part, if the user wants to access the account in order to connect to the e-wallet, the user will be asked to enter some personal data, such as full name, username, email, password, phone number, and address.
```
POST: localhost:8092/register
```
* Request Body
```
{
    "name": "LeBron James",
    "email": "curry@nba.com",
    "phoneNumber": "0812345678",
    "address": "San Fransisco",
    "username": "jamesnba",
    "password": "12345678"
}
```
#### Sign-in account
After the user registers an account and wants to access the e-wallet, the user must first sign in, if the user does not log in, the user cannot access the e-wallet. In order for the user to sign in, the user must enter a username and password.
```
POST: localhost:8092/signin
```
* Request Body:
```
{
    "username":"jamesnba",
    "password":"12345678"
}
```
#### Update account
Users can also update their accounts, however, not everything in the user account can be updated, only email, phone numbers, and passwords can be updated, if the user changes other than those that can only be changed, the updates entered will not be replaced.
```
PUT: localhost:8092/account
```
* Request Body
```
{
    "name": "LeBron James",
    "email": "curry@nba.com",
    "phoneNumber": "0812121212",
    "address": "San Fransisco",
    "username": "jamesnba",
    "password": "87654321"
}
```
#### View account information
Users can view their data by entering their user id.
```
GET: localhost:8092/account?id=deb97553398446a99633be442497504b
```
#### Delete account
The user can delete his account by entering the user id.
```
DELETE: localhost:8092/account
```
### Wallet
In the wallet section, users can do create wallet, view wallet information, and delete wallet.
#### Create wallet
Users can create more than one e-wallet. In order for a wallet to be created, the user must have an account because if you want to create an e-wallet, you need a balance and ID from the account owner.
```
POST: localhost:8092/wallet
```
Request Body
```
{
    "name":"Uvo",
    "balance":25000,
    "accountIdTransient":"8a8ab2977c43e5b8017c43e688130000"
}
```
#### View wallet information
Users can view e-wallet information by entering the e-wallet id.
```
GET: localhost:8092/account?id=deb97553398446a9213k123k3j1k312
```
#### Delete wallet
E-wallet can be deleted by entering the account owner's e-wallet id.
```
DELETE: localhost:8092/account
```
### Transaction
In the transaction section, users can do top-up wallet, withdraw wallet, and see history transaction. 
#### Top-up
Users can top-up or make a deposit to the e-wallet. The balance in the wallet will increase if the user does a top-up. The user is required to enter the account id, wallet id, and top-up balance to top-up.
```
POST: localhost:8092/topup
```
Request Body
```
{
    "account":{
        "id":"8a8ab2977c43e5b8017c43e688130000"
    },
    "wallet":{
        "id":"8a8ab2977c44d318017c44d4b0590000"
    },
        "transactionType":"Top up",
        "balance":1000000
}
```
#### Withdraw
Users can withdraw or withdraw cash from the e-wallet. The balance in the wallet will decrease if the user makes a withdrawal. Users are required to enter account id, wallet id, and top-up balance to top-up.
```
POST: localhost:8092/withdraw
```
Request Body
```
{
    "account":{
        "id":"8a8ab2977c43e5b8017c43e688130000"
    },
    "wallet":{
        "id":"8a8ab2977c44d318017c44d4b0590000"
    },
        "transactionType":"Withdraw",
        "balance":50000
}
```
#### History Transaction
In the transaction history section, the user can see the history of whether the user has made a top-up or has made a withdrawal.
```
GET: localhost:8092/transactions
```
## Support
Further information email me : [ariefmaulanaa19@gmail.com]()
