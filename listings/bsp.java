public boolean openConnection(){
        try {
            String databaseName = test
            String databaseURL = "localhost";
            String databasePort = "3306";
            String dbUsername = "root";
            String dbPassword = "root";
            Class.forName(DATABASE_DRIVER).newInstance();
            Properties dbProperties = new Properties();
            dbProperties.put(DATABASE_USER, dbUsername);
            dbProperties.put(DATABASE_PASSWORD, dbPassword);
            dbProperties.put(MYSQL_AUTO_RECONNECT, "true");
            dbProperties.put(MYSQL_MAX_RECONNECTS, "4");
            dbConnection = DriverManager.getConnection("jdbc:mysql://" + databaseURL + ":" + databasePort + "/" + databaseName, dbProperties);
            statement = dbConnection.createStatement();
	    dbProperties = null;
            databaseName = null;
            databaseURL = null;
            databasePort = null;
            dbUsername = null;
            dbPassword = null;
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }