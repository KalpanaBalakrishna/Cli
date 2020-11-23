## 1. List how many files (hidden files included) are there in your home directory
ls -al | grep '^-' | wc -l
## 2. List how many directories (hidden dirs included) are there in your home directory
ls -al | grep '^d' | wc -l
## 3. List all files/directories starting with letter “D” in your home directory
ls -al D* 
## 4. Change permissions to a text file by giving read-write access to owners and groups only.
chmod 660  sample.txt
## 5. Find out which processes are taking up maximum CPU
top -o %MEM
## 6. Find out which processes are taking up more memory
top -o %CPU 
## 7. Copy a text file from home directory to “tmp” directory
cd -
cp LICENSE.txt /tmp/
cd /tmp/
ls -l L*
## 8. Given a text file, employee.txt, find out the following
### a. List all employee ids, names and role whose name starts with “J”
awk '$2~/^J/ {print}' employee.txt
200  Jason   Developer  Technology  $5,500
600  Jonny   Developer Technology  $7,000
### b. List all fields, sorted by name in ascending order whose department is “Technology” and write them into emp.txt
awk '$4~/Technology/ {print}' employee.txt | sort -k2
200  Jason   Developer  Technology  $5,500
600  Jonny   Developer Technology  $7,000
500  Randy   DBA        Technology  $6,000
300  Sanjay  Sysadmin   Technology  $7,000
### c. List name and salaries of employees who work in “Technology” department as a “Sysadmin” and overwrite emp.txt
awk '/Sysadmin/ {print $2 $5}' employee.txt | sort -k2 > emp.txt
### d. Calculate the average salary of all employees
awk ' BEGIN {sum=0; count = 0} { gsub("[,$]","",$5); sum += $5; count += 1} END {print sum/count}' employee.txt
6666.67
### e. List the distinct departments in the organisation.
awk '{print $4}' employee.txt | sort | uniq
### f.Count the number of employees who are developers
awk '$3~/Developer/{print}' employee.txt | wc -l
### g. Print the distinct salaries of employees without $ sign
awk '{ gsub("[$]","",$5)}{print $5}' employee.txt | sort | uniq
5,000
5,500
6,000
7,000
9,500
# OS
## 1. Find out how to determine the OS architecture? (Is it 32 bit or 64 bit) 
uname -m
## 2. How to shutdown the OS from the command line.
shutdown -h
## 3. Find out what shell you are using.
echo "$SHELL"
## 4. Find out which processes are taking more memory from the command line?
top or free
## 5. How do you terminate one process from the command line ?
kill <pid>
## 6. What is a symlink ? And how do you create one ?
Symlink is nothing but soft link which  can point to another file. Its kind of shortcut.
ln -s employee.txt soft_link
# Network
## 1. ping
helps to test the reachability of a host.
## 2. nslookup.
helps to get information about the DNS(Domain Name System). Its a network administration tool to get IP address or other DNS record.
## 3. command to find ip address and mac id of the interface
ip route list
ip link show
## 4. find the hostname of the machine.
hostname

 
