# Documentation - Sprint 3

<img width="1300" height="240" alt="image" src="https://github.com/user-attachments/assets/7be1261c-228e-4f50-9257-df0f0a3239ea" />

## <p align="center">Radarius</p>
<p align="center">
    <a href="#challenge">Challenge</a>  |
    <a href="#user-stories">User Stories</a>  |
    <a href="#dor">DoR</a>  |
    <a href="#dod">DoD</a>  |
    <a href="#burndown">Burndown</a>  |
    <a href="#team">Team</a>
</p>

> Sprint Status: Done ✅

<span id="challenge">

## 🏅 Challenge

Implement features that improve the user experience for managing the data in the database, ensuring more control over it. This sprint covers splitting features by user permissions, user and alert screens, and displaying indicator levels on the home screen map, ensuring more reliability and control in decision-making.

<span id="user-stories">

## 📋 User Stories

Estimated team capacity for the Sprint: 107 Story Points (hours)

Sprint Goal: User Stories ranked 4, 6, 8, 12 and 13 (91 Story Points in total)

Sprint Forecast: User Story ranked 11 (6 Story Points)

NOTE: Changes were necessary. User stories marked with * (asterisk) were created during Sprint 3 planning due to scope changes (49 hours)

| Rank | Priority | User Story | Estimate | Sprint |
|-|-|-|-|-|
| 4 | 🔴 High * | As a client, I want each user role (manager, agent and public) to have different access to each feature | 26 | 3 |
| 6 | 🟡 Medium | As a manager, I want to be able to assign an agent user or a manager user to a zone, so they receive specific, centralized information to act on | 16 | 3 |
| 8 | 🟡 Medium | As a manager, I want zones to include information about the main roads and show the condition of each road, so I can act faster and more precisely at critical points in the city | 26 | 3 |
| 12 | 🟡 Medium * | As an agent and as a manager, I want to be able to view all alerts in the database | 16 | 3 |
| 13 | 🟡 Medium * | As a manager, I want to be able to view and manage all users in the database | 7 | 3 |
| 14 | 🟢 Low | As a manager, I want logs of the generated alerts, for audit records and to study the history of traffic behavior | 6 | 3 |

User stories removed because they could not be delivered on time and/or due to scope changes (70 hours)

| Rank | Priority | User Story | Estimate | Sprint |
|-|-|-|-|-|
| 5 | 🟡 Medium | As a manager, I want the indicators documentation screen (rank 3) to allow adding, editing and deleting indicators, so I have control over the city's traffic monitoring | 16 | 3 |
| 6 | 🟡 Medium | As a manager, I want to be able to change the level definitions of an indicator without changing the number of existing levels, so that alerts, which depend on these levels, are triggered at controlled moments | 12 | 3 |
| 15 | 🟢 Low | As a manager, I want an internal chat in the product so I can query information in the database in a simplified way | 42 | 3 |

<span id="dor">

## 🏃‍ DoR

|             Criterion             | Description                                                                                       |
| :-------------------------------: | ------------------------------------------------------------------------------------------------- |
|       Clear Description           | The User Story is written in the format "As a [persona], I want [action] so that [goal]"          |
| Defined Acceptance Criteria       | The story has objective criteria that indicate what is needed to consider it done.                |
|   Visual Reference in Figma       | The corresponding prototype is available and linked (when applicable to the frontend).            |
|     Validated Technical Scope     | It is clear whether the story involves frontend, backend or both.                                 |
|    Defined Access Profile         | The user type (regular or administrator) is clearly defined for each story.                       |
|      Shared Understanding         | The whole team (including PO and devs) understands the purpose of the story.                      |
|            Estimable              | The story was scored in Planning Poker or has a clear estimate.                                   |
|       Supporting Documents        | When needed, mockups, flows or data models are attached or referenced.                            |
|  Validated with PO and team       | The story was discussed in refinement or planning and validated with the technical team.          |
|   Agreed Technical Criteria       | Frontend and Backend needs were clearly separated (when applicable).                              |
| Alignment with current architecture | The proposed feature is consistent with what was already delivered in Sprints 1 and 2.      |

<span id="dod">

## 🏆 DoD

|                 Criterion                | Description                                                                                                      |
| :--------------------------------------: | ---------------------------------------------------------------------------------------------------------------- |
|        Acceptance Criteria met           | All scenarios defined in the US were implemented and successfully validated.                                     |
|    Test Scenarios run and approved       | All described scenarios were manually validated.                                                                 |
|      Visual Feedback Implemented         | Features such as pop-ups, error messages or progress bars are clear and accessible to the user.                  |
|        Safe and Controlled Flow          | There are no broken paths or inconsistent submissions in the evaluation or navigation flow.                      |
|        Code Reviewed (Code Review)       | The code was reviewed by at least one teammate.                                                                  |
|     Internal Documentation Updated       | Whatever was needed was updated: API, data structures, endpoints, etc.                                           |
|  Integration With the Rest of the App    | The feature was tested together with the full system flow (e.g. Submit → Response → Evaluation → Choice).        |
|             PO Validation                | The PO tested and confirmed that the feature works as expected.                                                  |
|            Ready for deploy              | The feature can be delivered to production/final testing with nothing pending.                                   |

<span id="burndown">

## 📉 Burndown

<div align="center">
<img src="../../../media/burndown-sprint-3.png" />
</div>

<span id="team">

## 👥 Team

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
