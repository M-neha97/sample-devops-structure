# 🐳 Docker Automation Pipelines

This folder contains Jenkins Groovy scripts designed to automate containerized deployments. These pipelines handle everything from simple web server provisioning to full Java application CI/CD lifecycles.

---

## 📋 Script Reference

| File Name | Description | OS | Shell |
| :--- | :--- | :--- | :--- |
| **`nginx-using-docker-pipeline.groovy`** | Pulls the official Nginx image and launches a container on port 10000. | Windows | `bat` |
| **`maven-docker-deploy-win.groovy`** | Full Pipeline: GitHub Clone → Maven Build → Docker Build → Run. | Windows | `bat` |
| **`maven-docker-deploy-linux.groovy`** | Full Pipeline: GitHub Clone → Maven Build → Docker Build → Run. | Ubuntu | `sh` |

---

## 🚀 Pipeline Overviews

### 1. Nginx Deployment
The **`nginx-using-docker-pipeline.groovy`** script is a lightweight workflow that automates the deployment of an Nginx web server. It handles the image pull and container lifecycle specifically for Windows-based Jenkins agents.

### 2. Java Maven Deployment
These pipelines manage a comprehensive "Build, Ship, and Run" flow. They are designed to pull Java source code from GitHub, compile it into an executable JAR, and wrap it in a Docker container.

* **Windows Version**: Uses `bat` commands for environment compatibility.
* **Ubuntu Version**: Uses `sh` commands and handles Linux-specific container management.



---

## 🛠️ Prerequisites

### **Windows Agents**
* **Docker Desktop:** Must be running.
* **Path:** `mvn` and `docker` must be in the System PATH.

### **Ubuntu Agents**
* **Docker Engine:** Installed and active.
* **Permissions:** Jenkins user must be in the `docker` group.
* **Maven:** Installed via `apt`.

<!---
---

## 🔗 Navigation
* [**Return to Main Repository**](../README.md)
-->
