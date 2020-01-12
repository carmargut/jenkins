# Jenkins

---

To use it, simply:

```bash
git clone https://github.com/carmargut/jenkins
cd jenkins
docker build -t jenkins-docker .
mkdir -p /var/jenkins_home
chown -R 1000:1000 /var/jenkins_home/
docker run -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock --name jenkins -d jenkins-docker

```
