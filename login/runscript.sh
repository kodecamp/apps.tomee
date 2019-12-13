java -cp "$H2_HOME/bin/h2-1.4.200.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost:9091/~/DevTools/Databases/UserDatabase -user kodecamp -password kodecamp -script ./script.sql
echo "Script Run Successfully"
