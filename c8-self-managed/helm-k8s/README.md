## Tutorials
https://github.com/asansanwal/camunda
https://www.youtube.com/watch?v=gIif4R41C7Q

## Run the following
```
kubectl apply -f https://raw.githubusercontent.com/projectcalico/calico/v3.25.0/manifests/calico.yaml
kubectl cluster-info
kubectl get pods -n kube-system
kubectl apply -f https://raw.githubusercontent.com/rancher/local-path-provisioner/master/deploy/local-path-storage.yaml
kubectl patch storageclass local-path -p '{\"metadata\": {\"annotations\":{\"storageclass.kubernetes.io/is-default-class\":\"true\"}}}'
kubectl get storageclass

snap install helm --classic
helm repo add camunda https://helm.camunda.io
helm repo update

helm upgrade --install ingress-nginx ingress-nginx   --repo https://kubernetes.github.io/ingress-nginx   --namespace default
kubectl get IngressClass

helm install camunda-platform camunda/camunda-platform -f ingress.yaml

kubectl patch svc default-ingress-nginx-controller -n default -p '{"spec": {"type": "LoadBalancer", "externalIPs":["192.168.1.81"]}}'

snap install zbctl

kubectl apply -f zeebe-gateway.yaml

kubectl patch svc camunda-zeebe-gateway-lb -n default -p '{\"spec\": {\"type\": \"LoadBalancer\", \"externalIPs\":[\"192.168.1.81\"]}}'
```