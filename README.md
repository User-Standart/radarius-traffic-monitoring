<img width="1300" height="240" alt="image" src="https://github.com/user-attachments/assets/7be1261c-228e-4f50-9257-df0f0a3239ea" />

<br />

<span id="radarius">

# <p align="center">Radarius</p>
<p align="center">
    <a href="#challenge">Challenge</a>  |
    <a href="#solution">Solution</a>  |
    <a href="#product-backlog">Product Backlog</a>  |
    <a href="#dor">DoR</a>  |
    <a href="#dod">DoD</a>  |
    <a href="#sprint-schedule">Sprint Schedule</a>  |
    <a href="#technologies">Technologies</a> |
    <a href="#installation-manual">Installation Manual</a> |
    <a href="#user-manual">User Manual</a> |
    <a href="#api-documentation">API Documentation</a> |
    <a href="#database-modeling">Database Modeling</a> |
    <a href="#team">Team</a>
</p>

> Project Status: Finished ✅ <br /><br />
> Documentation folder: [Link](docs) 📄 <br /><br />
> Project videos: [Public user flow](https://drive.google.com/file/d/1G6b-caz4GOOALUhfYMFFiktgj53RN-BM/view?usp=sharing) / [Agent user flow](https://drive.google.com/file/d/12RU3fXxbnhlbY8p932MR_5re0Mrc_VQK/view?usp=sharing) / [Manager user flow](https://drive.google.com/file/d/1vHfJ08QC7UmmriwL5C7PuEZcnNhNgzLA/view?usp=sharing) / [Admin user flow](https://drive.google.com/file/d/1J-53EJ_zDeAMko_-KFkLkkIGlr-jld9O/view?usp=sharing) 📽️

<span id="challenge">

## 🏅 Challenge

Given the need to improve urban traffic management in São José dos Campos, the challenge is to implement a proactive solution for monitoring and responding to incidents. The city lacks an integrated system that turns radar data into actionable insights, defines specific indicators to trigger alerts and efficiently allocates mobility agents to the most critical areas and situations, optimizing resources and improving traffic flow.

<span id="solution">

## 🏅 Solution

We developed an Intelligent Traffic Monitoring and Alert System. This solution centralizes traffic control through the radars, allowing the registration of custom indicators and severity levels. Based on these parameters, the system issues automatic alerts, enables the selection of strategic subzones and makes it easy to assign mobility agents to each area. The solution is complemented by an interactive dashboard that offers a consolidated, real-time view of all performance indicators, traffic patterns and agent metrics. Through this dashboard, managers can make fast, data-driven decisions, raising operational efficiency and the quality of traffic management in the city.

→ [Back to top](#radarius)

---

<span id="product-backlog">

## 📋 Product Backlog

NOTE: Changes were necessary. User stories marked with * (asterisk) were created during Sprint 3 planning due to scope changes (49 hours), and user stories marked with ~ (tilde) were removed because they could not be delivered on time and/or due to scope changes (70 hours).

| Rank | Priority | User Story | Story Points | Sprint |
|-|-|-|-|-|
| 1 | 🔴 High | As a manager, I want traffic information in the form of dashboards, charts and tables to support my decisions on reducing traffic | 48 | 1 |
| 2 | 🔴 High | As a platform user, I want a map on the home screen showing the zone divisions of São José dos Campos, so I can have a detailed view of the places the system has information about | 30 | 1 |
| 3 | 🔴 High | As a public user or agent, I want a screen with the indicators' documentation so I know what is being evaluated on the city map | 42 | 1 |
| 4 | 🔴 High * | As a client, I want each user role (manager, agent and public) to have different access to each feature | 26 | 3 |
| 5 | 🟡 Medium ~ | As a manager, I want the indicators documentation screen (rank 3) to allow adding, editing and deleting indicators, so I have control over the city's traffic monitoring | 22 | 1 |
| 6 | 🟡 Medium ~ | As a manager, I want to be able to change the level definitions of an indicator without changing the number of existing levels, so that alerts, which depend on these levels, are triggered at controlled moments | 12 | 2 |
| 7 | 🟡 Medium | As a manager, I want to be able to assign an agent user or a manager user to a zone, so they receive specific, centralized information to act on | 16 | 2 |
| 8 | 🟡 Medium | As an agent and as a manager, I want to receive alerts when the level of any indicator changes, so I know when traffic gets worse and can take action to solve the problem | 39 | 2 |
| 9 | 🟡 Medium | As a manager, I want zones to include information about the main roads and show congestion on them, so I can act faster and more precisely at critical points in the city | 20 | 2 |
| 10 | 🟡 Medium | As a manager, I want to be able to create "root causes" for triggered alerts and create protocols for these "root causes", so the agent has guidance on how to resolve the alerts that come up | 18 | 2 |
| 11 | 🟡 Medium | As an agent, I want to be able to view a specific alert, so I can document information about it, get information on how to solve the problem that generated it, and close it | 33 | 3 |
| 12 | 🟡 Medium * | As an agent and as a manager, I want to be able to view all alerts in the database | 16 | 3 |
| 13 | 🟡 Medium * | As a manager, I want to be able to view and manage all users in the database | 7 | 3 |
| 14 | 🟢 Low | As a manager, I want logs of the generated alerts, for audit records and to study the history of traffic behavior | 6 | 3 |
| 15 | 🟢 Low ~ | As a manager, I want an internal chat in the product so I can query information in the database in a simplified way | 42 | 3 |

<br />

<details>
    <summary>Original User Stories</summary>
    <br />

| Rank | Priority | User Story | Story Points | Sprint |
|-|-|-|-|-|
| 1 | 🔴 High | As a manager, I want traffic information in the form of dashboards, charts and tables to support my decisions on reducing traffic | 48 | 1 |
| 2 | 🔴 High | As a platform user, I want a map on the home screen showing the zone divisions of São José dos Campos, so I can have a detailed view of the places the system has information about | 30 | 1 |
| 3 | 🔴 High | As a public user or agent, I want a screen with the indicators' documentation so I know what is being evaluated on the city map | 42 | 1 |
| 4 | 🟡 Medium | As a manager, I want the indicators documentation screen (rank 3) to allow adding, editing and deleting indicators, so I have control over the city's traffic monitoring | 22 | 1 |
| 5 | 🟡 Medium | As a manager, I want to be able to change the level definitions of an indicator without changing the number of existing levels, so that alerts, which depend on these levels, are triggered at controlled moments | 12 | 2 |
| 6 | 🟡 Medium | As a manager, I want to be able to assign an agent user or a manager user to a zone, so they receive specific, centralized information to act on | 16 | 2 |
| 7 | 🟡 Medium | As an agent and as a manager, I want to receive alerts when the level of any indicator changes, so I know when traffic gets worse and can take action to solve the problem | 39 | 2 |
| 8 | 🟡 Medium | As a manager, I want zones to include information about the main roads and show congestion on them, so I can act faster and more precisely at critical points in the city | 20 | 2 |
| 9 | 🟡 Medium | As a manager, I want to be able to create "root causes" for triggered alerts and create protocols for these "root causes", so the agent has guidance on how to resolve the alerts that come up | 18 | 2 |
| 10 | 🟡 Medium | As an agent, I want to be able to view a specific alert, so I can document information about it, get information on how to solve the problem that generated it, and close it | 33 | 3 |
| 11 | 🟢 Low | As a manager, I want logs of the generated alerts, for audit records and to study the history of traffic behavior | 6 | 3 |
| 12 | 🟢 Low | As a manager, I want an internal chat in the product so I can query information in the database in a simplified way | 42 | 3 |

</details>

→ [Back to top](#radarius)

---

<span id="dor">

## 🏃‍  DoR - Definition of Ready
- User Stories with Acceptance Criteria
- Subtasks broken down from the USs
- Design in Figma
- Database Modeling
- Route Diagram
- Client's Vectorized Database

<span id="dod">

## 🏆 DoD - Definition of Done
- Installation Manual
- User Manual
- API (Application Programming Interface) Documentation
- Complete code
- Videos of each delivery stage

→ [Back to top](#radarius)

---

## 📅 Sprint Schedule

<span id="sprint-schedule">

| Sprint | Period | History |
|-|-|-|
| SPRINT 1 | 09/08 - 09/28 | [Sprint 1 Docs](docs/processo/sprints/sprint-1/README.md) |
| SPRINT 2 | 10/06 - 10/26 | [Sprint 2 Docs](docs/processo/sprints/sprint-2/README.md) |
| SPRINT 3 | 11/03 - 11/23 | [Sprint 3 Docs](docs/processo/sprints/sprint-3/README.md) |

→ [Back to top](#radarius)

---

<span id="technologies">

## 💻 Technologies

<p align="center">
  <img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white" />
  <img src="https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D" />
  <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white" />
  <img src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white" />
  <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white" />
  <img src="https://img.shields.io/badge/VS_Code-CED4DA?style=for-the-badge&logo=visual-studio-code&logoColor=0078D4" />
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />
  <img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white" />
  <img src="https://img.shields.io/badge/Google%20Docs-CED4DA?style=for-the-badge&logo=google-docs&logoColor=0D96F6" />
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />
</p>

→ [Back to top](#radarius)

---

<span id="installation-manual">

## 📖 Installation manual

Access the manual via this [Link](docs/install/README.md)
<br />

→ [Back to top](#radarius)

---

<span id="user-manual">

## 📘 User manual

Access the manual via this [Link](https://drive.google.com/file/d/1L-FXcJWop9PP2Nl430whKPjNdSdH5czI/view?usp=sharing)
<br />

→ [Back to top](#radarius)

---

<span id="api-documentation">

## 📓 API Documentation

Access the Swagger documentation via this [Link](https://drive.google.com/drive/folders/1cTevsjRi3AkroBniEprjlUZcLx0zNM3g?usp=sharing)

→ [Back to top](#radarius)

---

<span id="database-modeling">

## 🖥️ Database Modeling

<img alt="database modeling" src="./docs/media/modelagem-banco-de-dados.png" />

→ [Back to top](#radarius)

---

<span id="team">

## :busts_in_silhouette: Team

<div align="center">

|    Role       | Name                  | LinkedIn & GitHub |
|---------------|-----------------------|-------------------|
| Product Owner | Augusto Piatto        | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/augusto-piatto/) [![GitHub](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/augustopiatto) |
| Scrum Master  | Beatriz Sthefanny     | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/beatriz-santos-0b6773220/) [![GitHub](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/BeatrizSantos00) |
| Dev Team      | Caio Osorio           | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/caiovosorio/) [![Github](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/User-Standart) |
| Dev Team      | Davi Soares           | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/dsf21/) [![Github](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/DaviSFS21) |
| Dev Team      | João Paulista         | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/joaopaulista/) [![Github](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/joaopaulista) |
| Dev Team      | Rafael Slivka         | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/rafael-lopes-slivka-07753326a/) [![GitHub](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/rafaslivka) |
| Dev Team      | Tiago Bernardo        | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/tiagobernardosantos/) [![GitHub](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/TiagoBernardoSantos) |
| Dev Team      | Tiago Torres          | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/tiago-torres-dos-reis/) [![Github](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/TiagoTReis) |
| Dev Team      | Victor Ryan           | [![Linkedin](https://img.shields.io/badge/Linkedin-blue?logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/victor-ryan-51738b261) [![GitHub](https://img.shields.io/badge/GitHub-111217?logo=github&logoColor=white)](https://github.com/yzvictorr) |

</div>

→ [Back to top](#radarius)
