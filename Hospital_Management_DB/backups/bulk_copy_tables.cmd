@ECHO OFF
SET MYPATH=%~dp0
IF EXIST %MYPATH%bulk_copy_errors.log del /F %MYPATH%bulk_copy_errors.log
mysql_config_editor.exe remove --login-path=wb_migration_source 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
mysql_config_editor.exe set --login-path=wb_migration_source -h127.0.0.1 -P3306 -uadmin -p 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
SET command=mysql.exe -h127.0.0.1 -P3306 -uadmin -p -s -N information_schema -e "SELECT Variable_Value FROM GLOBAL_VARIABLES WHERE Variable_Name = 'datadir'" 2>> "%MYPATH%bulk_copy_errors.log"
FOR /F "tokens=* USEBACKQ" %%F IN (`%command%`) DO (
    SET DADADIR=%%F
)
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
pushd %DADADIR%
echo [0 %%] Creating directory dump_project
mkdir dump_project
pushd dump_project
copy NUL import_project.sql
echo SET SESSION UNIQUE_CHECKS=0; >> import_project.sql
echo SET SESSION FOREIGN_KEY_CHECKS=0; >> import_project.sql
echo use project_backup_12_11; >> import_project.sql
echo [4 %%] Start dumping tables
mysqldump.exe --login-path=wb_migration_source -t --tab=. project address --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename address.txt address.csv
del address.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/address.csv' INTO TABLE address FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [8 %%] Dumped table address
mysqldump.exe --login-path=wb_migration_source -t --tab=. project role --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename role.txt role.csv
del role.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/role.csv' INTO TABLE role FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [12 %%] Dumped table role
mysqldump.exe --login-path=wb_migration_source -t --tab=. project insurance_type --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename insurance_type.txt insurance_type.csv
del insurance_type.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/insurance_type.csv' INTO TABLE insurance_type FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [16 %%] Dumped table insurance_type
mysqldump.exe --login-path=wb_migration_source -t --tab=. project patient --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename patient.txt patient.csv
del patient.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/patient.csv' INTO TABLE patient FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [20 %%] Dumped table patient
mysqldump.exe --login-path=wb_migration_source -t --tab=. project billing --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename billing.txt billing.csv
del billing.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/billing.csv' INTO TABLE billing FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [24 %%] Dumped table billing
mysqldump.exe --login-path=wb_migration_source -t --tab=. project prescription --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename prescription.txt prescription.csv
del prescription.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/prescription.csv' INTO TABLE prescription FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [28 %%] Dumped table prescription
mysqldump.exe --login-path=wb_migration_source -t --tab=. project medicine_prescription --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename medicine_prescription.txt medicine_prescription.csv
del medicine_prescription.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/medicine_prescription.csv' INTO TABLE medicine_prescription FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [32 %%] Dumped table medicine_prescription
mysqldump.exe --login-path=wb_migration_source -t --tab=. project hospital --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename hospital.txt hospital.csv
del hospital.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/hospital.csv' INTO TABLE hospital FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [36 %%] Dumped table hospital
mysqldump.exe --login-path=wb_migration_source -t --tab=. project staff --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename staff.txt staff.csv
del staff.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/staff.csv' INTO TABLE staff FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [40 %%] Dumped table staff
mysqldump.exe --login-path=wb_migration_source -t --tab=. project department_patient_past --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename department_patient_past.txt department_patient_past.csv
del department_patient_past.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/department_patient_past.csv' INTO TABLE department_patient_past FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [44 %%] Dumped table department_patient_past
mysqldump.exe --login-path=wb_migration_source -t --tab=. project in_house_patient --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename in_house_patient.txt in_house_patient.csv
del in_house_patient.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/in_house_patient.csv' INTO TABLE in_house_patient FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [48 %%] Dumped table in_house_patient
mysqldump.exe --login-path=wb_migration_source -t --tab=. project medicines --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename medicines.txt medicines.csv
del medicines.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/medicines.csv' INTO TABLE medicines FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [52 %%] Dumped table medicines
mysqldump.exe --login-path=wb_migration_source -t --tab=. project department --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename department.txt department.csv
del department.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/department.csv' INTO TABLE department FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [56 %%] Dumped table department
mysqldump.exe --login-path=wb_migration_source -t --tab=. project insurance --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename insurance.txt insurance.csv
del insurance.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/insurance.csv' INTO TABLE insurance FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [60 %%] Dumped table insurance
mysqldump.exe --login-path=wb_migration_source -t --tab=. project appointment --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename appointment.txt appointment.csv
del appointment.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/appointment.csv' INTO TABLE appointment FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [64 %%] Dumped table appointment
mysqldump.exe --login-path=wb_migration_source -t --tab=. project out_house_patient --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename out_house_patient.txt out_house_patient.csv
del out_house_patient.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/out_house_patient.csv' INTO TABLE out_house_patient FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [68 %%] Dumped table out_house_patient
mysqldump.exe --login-path=wb_migration_source -t --tab=. project person --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename person.txt person.csv
del person.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/person.csv' INTO TABLE person FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [72 %%] Dumped table person
mysqldump.exe --login-path=wb_migration_source -t --tab=. project patient_backup --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename patient_backup.txt patient_backup.csv
del patient_backup.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/patient_backup.csv' INTO TABLE patient_backup FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [76 %%] Dumped table patient_backup
mysqldump.exe --login-path=wb_migration_source -t --tab=. project surgery_assistance --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename surgery_assistance.txt surgery_assistance.csv
del surgery_assistance.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/surgery_assistance.csv' INTO TABLE surgery_assistance FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [80 %%] Dumped table surgery_assistance
mysqldump.exe --login-path=wb_migration_source -t --tab=. project procedures --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename procedures.txt procedures.csv
del procedures.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/procedures.csv' INTO TABLE procedures FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [84 %%] Dumped table procedures
mysqldump.exe --login-path=wb_migration_source -t --tab=. project previous_checkin_dates --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename previous_checkin_dates.txt previous_checkin_dates.csv
del previous_checkin_dates.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/previous_checkin_dates.csv' INTO TABLE previous_checkin_dates FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [88 %%] Dumped table previous_checkin_dates
mysqldump.exe --login-path=wb_migration_source -t --tab=. project surgery --fields-terminated-by=, 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
rename surgery.txt surgery.csv
del surgery.sql
echo LOAD DATA INFILE 'project_backup_12_11_#####_import/surgery.csv' INTO TABLE surgery FIELDS TERMINATED BY ',' ENCLOSED BY ''; >> import_project.sql
echo [92 %%] Dumped table surgery
copy NUL import_project.cmd
(echo @ECHO OFF) >> import_project.cmd
(echo echo Started load data. Please wait.) >> import_project.cmd
(echo SET MYPATH=%%~dp0) >> import_project.cmd
(echo IF EXIST %%MYPATH%%import_errors.log del /F %%MYPATH%%import_errors.log) >> import_project.cmd
(echo SET command=mysql.exe -h127.0.0.1 -P3306 -uadmin -p -s -N information_schema -e "SELECT Variable_Value FROM GLOBAL_VARIABLES WHERE Variable_Name = 'datadir'" 2^>^> %%MYPATH%%import_errors.log) >> import_project.cmd
(echo FOR /F "tokens=* USEBACKQ" %%%%F IN ^(^`%%command%%^`^) DO ^() >> import_project.cmd
(echo     SET DADADIR=%%%%F) >> import_project.cmd
(echo ^)) >> import_project.cmd
(echo if %%ERRORLEVEL%% GEQ 1 ^() >> import_project.cmd
(echo     echo Script has failed. See the log file for details.) >> import_project.cmd
(echo     exit /b 1) >> import_project.cmd
(echo ^)) >> import_project.cmd
(echo pushd %%DADADIR%%) >> import_project.cmd
(echo mkdir project_backup_12_11_#####_import) >> import_project.cmd
(echo xcopy %%MYPATH%%*.csv project_backup_12_11_#####_import\* 2^>^> %%MYPATH%%import_errors.log) >> import_project.cmd
(echo if %%ERRORLEVEL%% GEQ 1 ^() >> import_project.cmd
(echo     echo Script has failed. See the log file for details.) >> import_project.cmd
(echo     exit /b 1) >> import_project.cmd
(echo ^)) >> import_project.cmd
(echo xcopy %%MYPATH%%*.sql project_backup_12_11_#####_import\* 2^>^> %%MYPATH%%import_errors.log) >> import_project.cmd
(echo if %%ERRORLEVEL%% GEQ 1 ^() >> import_project.cmd
(echo     echo Script has failed. See the log file for details.) >> import_project.cmd
(echo     exit /b 1) >> import_project.cmd
(echo ^)) >> import_project.cmd
(echo mysql.exe -h127.0.0.1 -P3306 -uadmin -p ^< project_backup_12_11_#####_import\import_project.sql 2^>^> %%MYPATH%%import_errors.log) >> import_project.cmd
(echo if %%ERRORLEVEL%% GEQ 1 ^() >> import_project.cmd
(echo     echo Script has failed. See the log file for details.) >> import_project.cmd
(echo     exit /b 1) >> import_project.cmd
(echo ^)) >> import_project.cmd
(echo rmdir project_backup_12_11_#####_import /s /q) >> import_project.cmd
(echo echo Finished load data) >> import_project.cmd
(echo popd) >> import_project.cmd
(echo pause) >> import_project.cmd
echo [96 %%] Generated import script import_project.cmd
popd
set TEMPDIR=%DADADIR%dump_project
echo Set fso = CreateObject("Scripting.FileSystemObject") > _zipIt.vbs
echo InputFolder = fso.GetAbsolutePathName(WScript.Arguments.Item(0)) >> _zipIt.vbs
echo ZipFile = fso.GetAbsolutePathName(WScript.Arguments.Item(1)) >> _zipIt.vbs
echo CreateObject("Scripting.FileSystemObject").CreateTextFile(ZipFile, True).Write "PK" ^& Chr(5) ^& Chr(6) ^& String(18, vbNullChar) >> _zipIt.vbs
echo Set objShell = CreateObject("Shell.Application") >> _zipIt.vbs
echo Set source = objShell.NameSpace(InputFolder).Items >> _zipIt.vbs
echo objShell.NameSpace(ZipFile).CopyHere(source) >> _zipIt.vbs
echo Do Until objShell.NameSpace( ZipFile ).Items.Count ^= objShell.NameSpace( InputFolder ).Items.Count >> _zipIt.vbs
echo wScript.Sleep 200 >> _zipIt.vbs
echo Loop >> _zipIt.vbs
CScript  _zipIt.vbs  "%TEMPDIR%"  "%DADADIR%dump_project.zip" 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
echo [100 %%] Zipped all files to dump_project.zip file
xcopy dump_project.zip %MYPATH% 2>> "%MYPATH%bulk_copy_errors.log"
if %ERRORLEVEL% GEQ 1 (
    echo Script has failed. See the log file for details.
    exit /b 1
)
del dump_project.zip
del _zipIt.vbs
del /F /Q dump_project\*.*
rmdir dump_project
popd
echo Now you can copy %MYPATH%dump_project.zip file to the target server and run the import script.
pause
