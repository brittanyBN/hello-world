# Hello World
This is a simple application with one endpoint that always returns HTTP-200 OK.

## Build
./gradlew build

## Run
./gradlew run

## Run in Docker
- Create jar file by running jar task: ./gradlew jar
- Test jar file: java -jar build/libs/restJakarta-1.0-SNAPSHOT.jar
- Create Dockerfile in root of project
- Create Docker image: docker build -t hello-world:v1 .
- Run Docker container: docker run -it --rm -p 8080:8080 hello-world:v1
- Test endpoint using command line tool: curl http://localhost:8080/hello/world
- Share Docker image to Docker registry (Docker Hub):
- Sign in to Docker Hub, and create a new repository (hello-world)
- Sign in to Docker Hub in command line: docker login -u YOUR-USER-NAME
- Add tag: docker tag hello-world:v1 YOUR-USER-NAME/hello-world:v1
- Push image to Docker Hub: docker push YOUR-USER-NAME/hello-world:v1

## Kubernetes
To deploy to kubernetes (minikube):
- Check that docker is running: docker
- Start minikube: minikube start
- Explore cluster: kubectl cluster-info
- Create yaml manifests in project then run: 
- kubectl apply -f deployment.yaml
- kubectl get deployment (check status)
- Optional to expose external IP:
  - kubectl apply -f service.yaml
  - kubectl get svc (check status)
  - In terminal shell: minikube tunnel + password (laptop password)
  - kubectl get services
  - Copy external IP address and test in web browser (+ endpoints)

## Deploy application via Helm
- helm install <location of the helm chart>
- To see Prometheus Helm Charts: helm search hub prometheus
- download: helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
- helm repo update
- Install: helm install prometheus prometheus-community/prometheus
- kubectl get service
- Expose the prometheus server: kubectl expose service prometheus-server --type=NodePort --target-port=9090 --name=prometheus-server-ext
  - ^ converts ClusterIP type to NodePort, making prometheus-server accessible outside the cluser on port 9090
- Access prometheus application: minikube service prometheus-server-ext

## Enable Remote Debugging
- Port forward debugging port (check deployment.yaml) to attach debugger
  - kubectl get pods
  - kubectl port-forward <your pod name> 5005:5005
  - New shell: kubectl port-forward <your pod name> 5005:5005
- Choose "run" in the toolbar, then "Edit Configurations"
- Click "+" then choose Remote JVM debug
- New shell: You can now run "curl http://localhost:8080/hello/world" and the debugger will be attached

