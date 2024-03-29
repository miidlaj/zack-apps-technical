# ZACK-APPS TECHNICAL

## ROLE BASED AUTHENTICATION AND AUTHORIZATION

### Endpoints

#### Login

```http request
POST /api/auth/signin HTTP/1.1
Host: http://43.204.36.88
Content-Type: application/json

No Authorization needed

{
  "username": "string",
  "password": "string"
}


usernames: 
[hr@zackapps.com, jr@zackapps.com, admin@zackapps.com]
password: 12345678
```

#### Get Employee List

```http request
GET /api/emp/list HTTP/1.1
Host: http://43.204.36.88
Authorization: Bearer token
Content-Type: application/json

[JR_ADMIN, HR_EXECUTIVE, ADMIN] are allowed
```

#### Add Employee

```http request
POST /api/emp/add HTTP/1.1
Host: http://43.204.36.88
Authorization: Bearer token
Content-Type: application/json

[ADMIN] are allowed

{
  "name": "string",
  "department": "string"
}
```


#### Delete Employee

```http request
DELETE /api/emp/delete/{EmployeeId} HTTP/1.1
Host: http://43.204.36.88
Authorization: Bearer token
Content-Type: application/json

[ADMIN] are allowed


```

#### Add Leave to Employee

```http request
POST /api/emp/leave/add/{EmployeeId} HTTP/1.1
Host: http://43.204.36.88
Authorization: Bearer token
Content-Type: application/json

[ADMIN] are allowed

{
  "reason": "string"
}

```


#### View Leave of Employees

```http request
GET /api/emp/leave/view/{EmployeeId} HTTP/1.1
Host: http://43.204.36.88
Authorization: Bearer token
Content-Type: application/json

[ADMIN, HR_EXECUTIVE] are allowed


```
