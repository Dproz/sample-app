#!/bin/sh
###########################################################################################
# name: user-setup.sh
#
############################################################################################
#Environment
environment=preprod

#Initialize the admin Users for MongoDB
admin_users=${APP_DB_ADMIN_USER}


#Initialize the Read Write Users for MongoDB
rw_users=${APP_DB_RW_USER}

#####Password Section for Users in Mongodb ###############

#Initialize the Passwords for admin Users in PREPROD
admin_pwd=${APP_DB_ADMIN_PASSWORD}


#Initialize the Passwords for Read Write Users in MongoDB in PREPROD
rw_pwd=${APP_DB_RW_PASSWORD}



# Main method which configures the mongo 

main() {
setup_users
}




setup_users(){
#Check if Mongo DB node is Primary
`mongo --eval 'db.isMaster().ismaster' | grep true 2>/dev/null`
result=$?

#Run this script only on MongoDB node
if [ $result -eq 0 ]; then
   

	  
    echo "================Switch to Sample database========================================================"

    mongo sample-app -u ${MONGO_INITDB_ROOT_USERNAME} -p ${MONGO_INITDB_ROOT_PASSWORD} --authenticationDatabase admin --eval '
		db.createUser( { user: "'${admin_users}'", pwd: "'${admin_pwd}'", roles: [ { role: "userAdmin", db: "sample-app" } ] } );
	 	db.createUser( { user: "'${rw_users}'", pwd: "'${rw_pwd}'", roles: [{ role: "readWrite", db: "sample-app" }] } );' 2>/dev/null
	
	echo "================Completed Read Write users creation in Mongo DB=================================================="
else
    echo "This script need to run on Mongo Primary node"
    exit 1      
fi
}

# Main starts here ......
main
