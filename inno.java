public class InnoDbCount{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/EMP";

   //  Variables to save Database credentials
   static final String USER = "username";
   static final String PASSWORD = "P@ssw0rd";
   
   public static void main(String[] args) {
   Connection connection = null;
   Statement stmt = null;
   try{ // This may throw SQLException. Hence enclose this block in try catch

      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection

      connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

      //STEP 4: Execute a query
      stmt = connection.createStatement();
      String sql;
      sql = "select *from information_schema.plugins where 
		plugin_name=’mysql_plugin’ ;
      ResultSet rs = stmt.executeQuery(sql);

if(rs.size() == 0) {


	System.out.rintln("InnoDB plug –in is not installed\n”);
	
}
else {

while(rs.next()){

	System.out.println("Count of InnoDB disk writes i :" + rs.size());
}
}

      
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){//Handle any other Exception than SQLException
      e.printStackTrace();
   } finally{
	//Close the unwanted resource objects
      rs.close();
      stmt.close();
      conn.close();
}

