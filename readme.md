There are two versions of the solution.
Both heavely influenced by: https://www.websparrow.org/spring/spring-security-jdbc-authentication-with-spring-boot

The "TWO_TABLES/boot-security-jdbc" is basicly an copy of the repository linked in the aforementioned guide, with httpBasic() instead of formLogin(). HttpBasic() provide an unexpected behaviour when using browsers (logout will most probably not occur until browser window is closed (session-end)).

The application in: "SINGLE_TABLE/boot-security-jdbc" replaces jdbcAuthentication with an custom authenticationProvider that only uses one table, defined by "service/UserService.java".
<br>
The use of two slightly different solutions is mostly to confuse people and show that I can use Repositories.

------------------------------------------
<h3>Installation and execution/"Test":</h3>

1.  Navigate into the Direcotry of choice and create DataBase using the command "bash create_db.sh"
2.  Start the server via "bash start_server.sh"
3.  'Test' the server via "bash test_server.sh"
   
-------------------------------------------
