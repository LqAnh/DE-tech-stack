Config mysql database name, usernam, password in pom.xml

API:
- GET
	-- localhost:8080/ : get all user
	-- localhost:8080/get/id : get user by id

- POST: create user
	-- localhost:8080/cr
	Note: email and password can not be empty or null
	      email can only be registered once

- PUT: update user by id
	-- localhost:8080/up/id
	Note: email and password can not be empty or null
              email can only be registered once

- DELETE: delete user by id
	-- localhost:8080/del/id
