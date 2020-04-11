#./startdb.sh &
java -cp "$H2_HOME/bin/h2-1.4.200.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/cmsDatabase -user kodecamp -password kodecamp -script ./script.sql
echo "Script Run Successfully"
