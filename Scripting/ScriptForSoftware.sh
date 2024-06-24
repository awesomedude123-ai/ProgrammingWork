#!/bin/usr/env bash

echo "Setting up Environment. Please take a look at the list of softwares."
sleep 10

cd ~
##Updating Apt-Get
sudo apt-get update

##Downloading Git
echo "*******************************************************Installing Git*******************************************************"
sudo apt-get install git-all

##Downloading Python
echo "*******************************************************Installing python3*******************************************************"
sudo apt install python3

##Downloading Pip
echo "*******************************************************Installing pip*******************************************************"
sudo apt install python3-pip

##Downloading Powershell
echo "*******************************************************Installing Powershell*******************************************************"
sudo apt-get install -y wget apt-transport-https software-properties-common
wget -q "https://packages.microsoft.com/config/ubuntu/$(lsb_release -rs)/packages-microsoft-prod.deb"
sudo dpkg -i packages-microsoft-prod.deb
rm packages-microsoft-prod.deb
sudo apt-get update
sudo apt-get install -y powershell
sudo snap install powershell

##Downloading Nmap
echo "*******************************************************Installing nmap*******************************************************"
sudo apt-get install nmap

##Downloading Sqlmap
echo "*******************************************************Installing sqlmap*******************************************************"
sudo apt-get install sqlmap

##Downloading Nikto
echo "*******************************************************Installing Nikto*******************************************************"
sudo apt install nikto -y
sudo apt install apache2 -y

##Downloading OpenVAS
echo "*******************************************************Installing OpenVAS*******************************************************"
sudo apt install wget apt-transport-https gnupg2 software-properties-common
sudo apt install sqlite3
sudo add-apt-repository ppa:mrazavi/openvas
sudo apt install openvas

##Downloading SET
echo "*******************************************************Installing SET*******************************************************"
git clone https://github.com/trustedsec/social-engineer-toolkit/ setoolkit/
cd setoolkit
pip3 install -r requirements.txt
sudo python setup.py
cd ~

##Downloading John the Ripper
echo "*******************************************************Installing John the Ripper*******************************************************"
sudo apt-get install john -y

##Downloading Metasploit
echo "*******************************************************Installing Metasploit*******************************************************"
wget http://downloads.metasploit.com/data/releases/metasploit-latest-linux-x64-installer.run
chmod +x ./metasploit-latest-linux-x64-installer.run
sudo ./metasploit-latest-linux-x64-installer.run

##Downloading Invoke-Obfuscation
echo "*******************************************************Installing Inoke-Obfuscation*******************************************************"
git clone https://github.com/danielbohannon/Invoke-Obfuscation.git

##Downloading Hashcat
echo "*******************************************************Installing Hashcat*******************************************************"
sudo apt install hashcat

##Downloading BeEF
echo "*******************************************************Installing BeEF*******************************************************"
sudo apt-add-repository -y ppa:brightbox/ruby-ng
sudo gem install bundler
git clone https://github.com/beefproject/beef
cd beef
./install
cd ~

##Downloading PowerUp
echo "*******************************************************Installing PowerUp*******************************************************"
git clone https://github.com/ibm/power-up
cd power-up
sudo ./scripts/install.sh
cd ~

##Downloading BeRoot
echo "*******************************************************Installing BeRoot*******************************************************"
git clone https://github.com/AlessandroZ/BeRoot.git

##Downloading PAExec
echo "*******************************************************Installing PAExec*******************************************************"
sudo apt-get update -y
sudo apt-get install -y paexec

##Downloading LaZagne
echo "*******************************************************Installing LaZagne*******************************************************"
git clone https://github.com/AlessandroZ/LaZagne.git
cd LaZagne
pip install -r requirements.txt
cd ~

##Downloading EvilURL
echo "*******************************************************Installing EvilURL*******************************************************"
git clone https://github.com/UndeadSec/EvilURL.git
cd EvilURL
pip install python-nmap python-whois
cd ~

##Downloading Pupy
echo "Installing Pupy..............."
Pupy Download
git clone https://github.com/n1nj4sec/pupy
cd pupy
git submodule init
git submodule update
pip install -r pupy/requirements.txt
cd ~

##Downloading DNSCAT2
echo "*******************************************************Installing DNSCAT2*******************************************************"
git clone https://github.com/iagox86/dnscat2.git

##Downloading Cloakify Factory
echo "*******************************************************Installing Cloakify Factory*******************************************************"
git clone https://github.com/TryCatchHCF/Cloakify.git

##Downloading DNSExfiltrator
echo "*******************************************************Installing DNSExfiltrator*******************************************************"
sudo apt-get dist-upgrade
sudo apt-get install bind9
sudo apt-get install dnsutils

echo "All softwares are downloaded and successful. If there is any other software that needs to be installed, you can add it to this script and add it to the list of software going to be installed."



echo "All software has been installed. Below is a list of the software downloaded and a list of possible softwares that can be installed but are not through this script."
$software_installed = ["Git","Python3","Pip","PowerShell","Nmap","Sqlmap","Nikto","OpenVAS","SET","Metasploit","Invoke-Obfuscation","Hashcat","BeEF",
"PowerUp","BeRoot","PAExec","LaZagne","EvilURL","Pupy","DNSCAT2","Cloakify Factory","DNSExfiltrator"]

echo "Software Downloaded:"
x=0
for i in $software_installed
do
    echo "$x: $i"
    x+=1
done

$software_not_installed_through_scipt=["Spiderfoot","Intrigue","Maltego","Shodan","SecurityTrails API","Veil","Gophish","King Phisher","BloodHound","Mimikatz","CrackMapExec"
,"Empire Project","Cobalt Strike","DET","Powershell-Rat","Hacktrails","SecurityTrails SQL"]

echo "Software Not Downloaded:"
x=0
for i in $software_not_installed_through_scipt
do
    echo "$x: $i"
    x+=1
done

echo "If you know how to download these software, please feel free to make changes to this script and increase its functionality"