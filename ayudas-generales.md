# git - bash (terminal)
Configuración
Los siguientes pasos se deben realizar en cada sistema operativo en el que queramos usar Git (aula Windows, aula Ubuntu, casa Ubuntu, casa Windows...). Se asume que ya se cuenta con una cuenta en github.com, en caso contrario crea una cuenta antes de continuar.

Si estás en Windows abre la aplicación Git Bash, en Ubuntu simplemente abre una terminal.

Antes de ejecutar estos comandos asegúrate de modificarlos definiendo los valores <username> e <email>.


Copy
git config --global user.name <username> 
git config --global user.email <email>
Ahora vamos a configurar la autenticación con ssh


Copy
# Ejecutar este comando y darle al ENTER hasta que termine el proceso
ssh-keygen -t rsa
Ahora debemos ejecutar el siguiente comando y copiar la salida


Copy
 # Este comando debe producir varias líneas de salida
 cat .ssh/id_rsa.pub 
El comando anterior debería producir una salida similar a esta


Copy
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCeJZ2y616u4rASVSmPHbXAHws8FT5zY6KYRbwbshmrH9E8qymA9bDckV0P5u9YbDJSNjW/vrFd/mK8sb3TVZ0F/mkBUphidK0u8Y2B9sdfsdfsdfsdfsdfsdfMHKX5DgT+QtIbzYrpe37KyaUE/QPK/DuH8be/PfYYiSMOvcPx89BDhIWT3H5kMtkjHRGTvNP+Ciee5/czNDsjkp4OqHrDge2fgssq3Qul2C/9p6UAAD56T2DOs/+IDAVXnvpSIbkicAUo5aYqyK77QcLL1oIsEto29B6vBmMsdPUg6C0GLY5eno5hDsGv03STLBm8cx1utCD5SD+M74np8mpgnxt4vW1KSdmoSqAbAJw4n7Fzcu/rcnup9BzNMmcMv+ORZtMv5oBBiUgG/jG6//ip6RZM0K7CAYprumIF3eRm4aQkWpILlGTJUA/2Yq5x3BDEKWO7IGy3CQw46KqBr4dmpfYpdjaKHmTJU0Uj5o2n6ek= alumno@alumnoPS-13-9360
Copia el contenido de la salida de principio a fin, asegúrate de que no te dejas nada.

En github.com ve a la opción settings


Ahora vamos a la opción SSH and GPG keys


Añadimos una nueva clave ssh

