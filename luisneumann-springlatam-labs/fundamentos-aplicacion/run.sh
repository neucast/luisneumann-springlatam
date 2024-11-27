#! /bin/bash

mvn -pl com.luis.neumann:fundamentos-aplicacion clean compile

mvn -pl com.luis.neumann:fundamentos-aplicacion exec:java -Dexec.mainClass="com.luis.neumann.main.Main" -Dexec.cleanupDaemonThreads=false