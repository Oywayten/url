# Authorization JWT
`Authorization in Rest applications occurs through a token - a key by analogy with sessionId in a servlet.`

1. Let's check that the security works. Let's try to get users without authorization
`curl -i http://localhost:8080/all` Result 403.
2. Register a user `curl -H "Content-Type: application/json" -X POST -d {"""username""":"""admin""","""password""":"""password"""} "localhost:8080/users/sign-up"`.
3. Let's get a token from this user `curl -i -H "Content-Type: application/json" -X POST -d {"""username""":"""admin""","""password""":"""password"""} "localhost:8080/login"`.
4. Get all users with this token `curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/users/all`.