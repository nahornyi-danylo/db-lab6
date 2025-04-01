# Розроблення функціональних вимог до системи

## Модель прецедентів

### Загальна схема
---
<center>
  
![Діаграма](//www.plantuml.com/plantuml/png/PP0zJWGn38LxdyBQVg-mMaHBXJG7Y18pHCeFEFPK79xWH1gKwVpvlJpRUJPnB9eJ9FeGb8eSzq_149cyn5e0d9VAk3NYMRw474jimguJW3RohX7U_YpuJlkG-jiRkeRAj5ZUwXwdbcAvYbLbghswnETwq0nUj5Sc9zGjtqfjHdXUy-cWXDjNwDOvHK-BdORh9ASCOCtx_M473KYTx8I1R5XL9gkPJx1juF_lMV_dOGDNmSBqsXtRFAa4pUaN)

</center>

### Користувач
---
<center>
  
![Діаграма](//www.plantuml.com/plantuml/png/VP8zJlGm48PxdsAq_QxqRVbf5ItQbcsGgD786I9BYGSyOmGTFmLtu1I8Yeep93SYSLm4hxJTQ9udR_nQtejYqDYr1groW5N_qVyCp_tty3Ay3c_zL_yvlAy01Qw5WZ5HoA8Gh2wivUWLZkYneOwy9gj3vs_-BJIFxPCu0Rw58zKEuS1U_zZRHUhq4xYYnea6LCS-QJ5GeLnoup9hdJ-573NJSJg9x_Y1Sd313e5GQLJk8qcEi0lfmDqT1YVifqAOof4app8QaqBMxRhA5v4N8ItchZE0JRsfvkF1VzZjw579rr9L1NV-70vqbXPmfjjCROcNr3AM7-_7ONedvXS0)

</center>

### Адміністратор
---
<center>
  
![Діаграма](//www.plantuml.com/plantuml/png/NS_DIWCn4C3nUvvYwBq5zoXbgNZLIw5d6RBJ4aacEX_5nzVTfQp9BV3_9PavgQ6ObnmmMXLucKhYf2PeLK9mfOXAiBie2M2CrTcW8EED2h7j01KA9lvuskpxd1FVmETBGjzEQhhHeNlsZUwKuV8reT6YFFj6bebWWMSgzRuITDd8Q-LhaeAMAaEzjb_6V_1CdnHj7gqX8X12Q5Q7VTwFZysw8eyoXB0AE4o7SHuRdk5uf1yZddGScuekNLtpiEROrIPA7yFfx-0b_m80)

</center>


### UserRegistration
---
![Діаграма](//www.plantuml.com/plantuml/png/XLFDxj904B_tAJRrQg9d8GGF73Zu1bxujWbiIRiO3nme5V10R698JOp6y0QrKiL2oolClf6_QPKqAFd3PNPcVXypksswgkEesMHipEaJvNf1H-tffVOffaXlvaPHDvu9-g13Eb3A7KLj9xYH8IXaAFXb8kOK9KXbEX2KqpSweID5X19zfrpGJuheKYZvDGFA-r8Lg3D5yq8DAcY7uX5kjW9q2NFf5Ti0TIZ0a8Cw0CCTxynJPM580hyUKXb506zBfWCE26gC-0BiafaeBQQa5Bqva3oXIH-HN81bnrBWAiK0m3amxqppbMLnZdK8IC2iCVu9X9CR1z9M0-5OerTAF1eEd-9drBiD-amv_Q1JkNkW4QJm_rvlU19i7fgO75RMq0ZgJxeDnfcjDvQhB3bwtklPCwbQZcCxvkDh-ONbkgYsvT1s9XrbsRBik3QqvUlEsEgtvNIcAgM1x0jsoiFj_ruwt60mNXRR-tLxzqYzb9MxvzP80EYL6AoXkXMqhFxiXSCQIwsnexSiHMVjirZwxxKpvmN9NA35GnZgTw18eFs_zvbLt-N3Z_N-Ps9FZIRMWa_fDm00)

|**ID:**                 | UserRegistration                                                                                                                                                                                                                                                                                                                                                                                       |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Створення нового облікового запису                                                                                                                                                                                                                                                                                                                                                                     |
| **УЧАСНИКИ:**          | Користувач, система                                                                                                                                                                                                                                                                                                                                                                                    |
| **ПЕРЕДУМОВИ:**        | Користувач не має облікового запису у системі                                                                                                                                                                                                                                                                                                                                                          |
| **РЕЗУЛЬТАТ:**         | Новий обліковий запис користувача                                                                                                                                                                                                                                                                                                                                                                      |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | 1. Користувач уже зареєстрований у системі - ExistingAccountError <br/> 2. Користувач не ввів необхідні дані - MissingInformationError <br/> 3. Користувач ввів некоректні дані - InvalidInputError                                                                                                                                                                                                          |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Користувач відкриває сторінку для створення облікового запису <br/> 2. Система виводить необхідні поля <br/> 3. Користувач вводить персональні дані (Електронна пошта та пароль) <br/> 4. Користувач натискає кнопку "Зареєструватися" <br/> 5. Система перевіряє введенні дані <br/> 6. Система створює новий обліковий запис на основі введених даних <br/> 7. Система інформує користувача про успішне створення нового облікового запису                                                                                                                                                                   |

---
### UserLogin
---
![Діаграма](//www.plantuml.com/plantuml/png/TLFDpj9G4DtVfxYf6rtfsduXkD34nF04RkG79P7MbB9ZGQa22mB6Q4sCnXXVu5f1i51uXPatyinWOXE11BYTSyxCcRdJ-Y1-5iN3_aipeazqv37jEE49fvIJuzd8A6xkMth76Qsf48PYxwqGHGAW191Qu7jUMNAK2wBKBQXJplYZRr3YspazRUX0RgHfDTqHqXtABYoL08_qWzzelP8pIoS4aDWtrqngdceMI3OmbY1KaeDuePc0EptSfW-qHw42xB6IGDD2FES9ZlZHPwSmz7TygVA5711Kfq97WByI-4dRz-Wx6i_ejr2yA_r-5MDu1X46Lv8Zfno1DRvLZxu9mhXZezxp5x6zrUtUmyVSD6lq6GL_mRrU0zGu572uv9asmOdE8FqxzzNDtMPDTDxZe1ismlXHE0pQ3wCeZ3o1h6ADy46h1I3-1sWSqSvWyAJNxrMHJj2sOaxwULkzQqvr9lzV4JaTtnIDlLRqSAQUPBmMvmJ7ZEV0qylxizGhUHf0SvwWDAjwiD6-JXAX2rk9RG8X4r-w93zHahQYLfEfRwulV_ZArD4kNf0_)

| **ID:**     | UserLogin                                                                                                                                                                                                                                                                                                                                  |
|:------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Вхід до облікового запису                                                                                                                                                                                                                                                                                                        |
| **УЧАСНИКИ:**          | Користувач, система                                                                                                                                                                                                                                                                                                                          |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис у системі                                                                                                                                                                                                                                                                                                     |
| **РЕЗУЛЬТАТ:**         | Вхід у обліковий запис                                                                                                                                                                                                                                                                                                   |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | 1. Користувач ввів не правильні дані - InfoNotFoundError <br/> 2. Користувач не має облікового запису - NoAccountError <br/> 3. Користувач зробив забагато спроб входу - AccessLimitError                                                                                                                                                                  |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Користувач відкриває сторінку для авторизації <br/> 2. Система виводить необхідні поля  <br/> 3. Користувач вводить персональні дані (Електронна пошта та пароль) <br/> 4. Користувач натискає кнопку "Увійти" <br/> 5. Система перевіряє введенні дані <br/> 6. Система авторизує користувача <br/> 7. Система інформує про успішну авторизацію та перенаправляє користувача на сторінку облікового запису                                                |

---
### UserLogout
---

![Діаграма](//www.plantuml.com/plantuml/png/XL9DJi906DtFAIRr0Ew543Okt7W72KHDb9fIToo0Ah0ma1Y3YT65DwWeKbfeh_1zD_AzQOmBqhYOzEltyxxttaop5vu5uUtrbUdBY-Gwa4I7Ej98bXBhf6zStHnPUTI5V4dA3bTxicpa20ex528hkNn8XjyKqHBdKt8hQucbSB1HpM3DUxb2LhALkE-W7MGE-0Ih7om1zOxGRD6nBdJsFxW1PbpEKi406hPOiaCwiS3ET6w1I9YypAqjY2Uo1QqAzI3tXcZ4lAHEDJuxW1HEiUUuRzZWLOXxbXXeA_2PQiJvWkjn9g0MmKJKXbHOCrq_xDZWylmYj0T1fstghOQyOjUtPANfLfO8KaYPSLnYZYUES6dJl7xOQd3EE_LFkiT1u0SUKzPqkcrBV58Q_zbRKahtjNDPGRiiMeO85pfrRcqS2RtdSw3bxACyMP4GPoYORXDvytjH9Cj8CbuVfU-zd-fhw8N-ZMb20Xxg3m00)

| **ID:**     | UserLogout                                                                                                                                                                                                                                                                                                                                    |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Вихід з облікового запису                                                                                                                                                                                                                                                                                                           |
| **УЧАСНИКИ:**          | Користувач, система                                                                                                                                                                                                                                                                                                     |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис та авторизований у нього                                                                                                                                                                                                                                                                                |
| **РЕЗУЛЬТАТ:**         | Вихід із облікового запису                                                                                                                                                                                                                                                                                        |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | Користувач не авторизований у обліковий запис - NoInError                                                                                                                                                                                                            |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Користувач відкриває сторінку облікового запису <br/> 2. Система виводить інформацію облікового запису та інстументи для роботи з ним <br/> 3. Користувач натискає кнопку "Вийти" <br/> 4. Система завершує поточну сесію <br/> 5. Система інформує користувача про успішний вихід з облікового запису та перенаправляє його на головну сторінку |

---

### UserRemove
---

![Діаграма](https://www.plantuml.com/plantuml/png/ZL9Fxz904BtlfzZKgucUBI5uuC313y5_cy2Mj8lnm46e0K-G4CF1Q8pVe2885bk-mjjlv1iQaMWmFnBQwRmtRtRUR2sspSYEXmCrmGSKxWsERkfcBi4MgLjCr0LNppJMReCTCc50iFTQY59282UGQ1JuYXC_CqPR_h-Xq3WWnHaYc_YARRwKBR37JwGJaVvCQaRMmIMK5JdtLeI5uEPkuvOFaJQXxUeewB-q-b6lzvG_LMbLyP7axpYLfzPy795HQUaMo9bmKzRBl6MdLUL9gofrNlrr4Dl0z9-ts-7Os7eKXP7t-0g_2EAOQCFqmcZOj45eIiQLq32lceEWqp2ZiRs1kgQZvQJgdk7qunEZcUIHGOpcAqV1ISLa3skEiEFad4beVtb3yCUDCzuTpwyYRiKE_vNmXJ__ivJBbd1cM6Z6Kvnft3lasDFUtx9ibRDavPSBtfFD316fIyah6qjAop9PmSwiIFwvLxwwVpd3aQhHKbxWNm00)

| **ID:**     | UserRemove                                                                                                                                                                                                                                                                                                                                    |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Видалення облікового запису                                                                                                                                                                                                                                                                                                           |
| **УЧАСНИКИ:**          | Користувач, система                                                                                                                                                                                                                                                                                                     |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис та авторизований у нього                                                                                                                                                                                                                                                                                |
| **РЕЗУЛЬТАТ:**         | Обліковий запис видалено                                                                                                                                                                                                                                                                                        |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | Користувач не має облікового запису - NoAccountError                                                                                                                                                                                                             |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Користувач відкриває сторінку облікового запису <br/> 2. Система виводить інформацію облікового запису та інстументи для роботи з ним <br/> 3. Користувач натискає кнопку "Видалити обліковий запис" <br/> 4. Система видаляє обліковий запис та інформацію про нього <br/> 5. Система інформує користувача про успішне видалення та перенаправляє його на головну сторінку |

---
### UserCreateRequest
---

| **ID:**     | UserCreateRequest                                                                                                                                                                                                                                                                                                                                    |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Створення запиту для аналізу медіа-контенту                                                                                                                                                                                                                                                                                                         |
| **УЧАСНИКИ:**          | Користувач, система                                                                                                                                                                                                                                                                                                     |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис та авторизований у нього                                                                                                                                                                                                                                                                                |
| **РЕЗУЛЬТАТ:**         | Запит створено                                                                                                                                                                                                                                                                                        |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | 1. Користувач не авторизований у обліковий запис - NoInError <br/> 2. Користувач ввів не правильні дані - InfoNotFoundError                                                                                                                                                                                                           |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Користувач натискає кнопку "Створити запит" <br/> 2. Система виводить необхідні поля <br/> 3. Користувач вводить дані про запит <br/> 4. Користувач натискає кнопку "Створити" <br/> 5. Система перевіряє введенні дані<br/> 6. Система створює запит<br/> 7. Система інформує користувача про успішне створення запиту та перенаправляє його на головну сторінку|

---
### UserLevelUpdate
---

![Діаграма](https://www.plantuml.com/plantuml/png/RCon3e8m4CRndQSueo-WcviLREA20qnk5tf0GtibxH7KfvV5X0INR_d_ybsIO9J9ksndgBLCe1zbNTsVDpYUiZHO7Z6YXoNYv4G7bif-20u_zj-Kw0bKjEYslQQNA6SxziG2pJ8KLwf7DdEq8iJGeakqQgb74sRBtROi9nJaFL9-nMReOfZOvC6527jrBl92hp07eOtIMdqBgPgTX84mUEzJRFe4tapeHGvUFNZcXaHDJ6iQZXo06lHWm1Y35t_Y6rG2Mg6qhp3xHixGZSI4wgsxyytFpcwwjz_ql1xkC4TkfrZRgHtOeUqZjKCKjj_pDcrv3RpW7Ta6U31O2kDIimbctBn6QaX93MRKcMCfN0Z7DIQ230WahH2VHelAYmev5boHpg_CaBwo4qE5WgO5zpD31iaPye1ntofhadAaFOQxbnSA4ZCgtbRYL_BKX1tnM6E3KeeruLkXx7Ud-Z_HNmKsyAo536djwbjJg5GNnXTCTbg9bg8gb45QfudKtzd2AnO45xe1vf_GQIldBaVnLzHa1zpDyCLZSA2KL4qpWQV7O-BpqxDkm-29p0-io9Kg9BAav9YZQzaCo2VRjJvfXVvnTD4vZECezdacrMVyewZPRlCbTgjzPdzqHnt_IXqG6MslqYP4wtjnfwozOVS0g390IV8D9H8MuDII7-E0hpwwz0uwuGd_4zy0)

| **ID:**     | UserLevelUpdate                                                                                                                                                                                                                                                                                                    |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Заміна прав користувача на права адміністратора                                                                                                                                                                                                                                                                                       |
| **УЧАСНИКИ:**          | Адміністратор, користувач, система                                                                                                                                                                                                                                                                       |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис                                                                                                                                                                                                            |
| **РЕЗУЛЬТАТ:**         | Система змінює користувачу права на адміністраторські                                                                                                                                                                                                                                                         |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | 1. Користувач вже має права адміністратора - RoleError <br/>  2. Користувач не має облікового запису - NoAccountError                                                                                                         |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Адміністратор обирає користувача та відкриває сторінку з інструментами для роботи з ним <br/> 2. Система виводить інформацію про користувача та інстументи для роботи з ним <br/> 3. Адміністратор натискає кнопку "Надати права адміністратора" <br/> 4. Система перевіряє права та обліковий запис користувача <br/> 5. Система змінює права <br/> 6. Система інформує адміністратора та користувача про успішну зміну прав                          |
---
### AdminUserRemove
---

![Діаграма](https://www.plantuml.com/plantuml/png/RCgnReCm483XdQUugds0jalLhIxKKXSom9JjX0-miC_eV8WaJn-MI4Xa-PV_-ycAeaiCHV7YgFTCO4zrs_oV_-3ZiyYJvna58smJbw0siJR-Hl3sOCzDZP70YCTm_2rTr0G_S2HMwBQGxDI8x5RngiJGOyYqUtb4brRFm_4e2IMzpbJ-OZSDaXPsPGf9uDLyLsLbTvYJqa5PQzw_xeLKJKx2K1ZSznHVUWpOoCAj9s27Hjs0QLYo06hG1G5Z32iryGPFf5eeb2lCkv4pl3GQ5ToGllVDptJwXKOKzN271TP-XesV-O4V-ZwS7wBq_LwqgokguHclo7U31yDACnw5JJ7dvGsSaU8CS-eiiDAS4y454q467AJDDZvCX-15XJKodaZdKswa5tvgL2XfMl8-Dp98ph6kC-vBi4P6kEintBsyK9AOKt4SnA_bAOGVyRKc9ZKK736zq7X3ILsQRgMdN8hmTxB_KXqkiOOd7MH3zr0XYIMTsOV5UW6o7Gf22FkHbSFbjwJntWuamP3KFoXWUiyz9MrvB8sJSMYe7cbtBBayl-ZM38-yVKSHlgr1oYlwJBW06saEgA-T27hJPZi-wJHQBMvTzpX9EadCfAClNvyggzlN75mLYC01jfpVqYUJSLLOnekDd4WH71a9kdIYydTULRAilhcIwebibaDs-cj7wrpypbKK7PsrJ_bdyGa0)   

| **ID:**     | AdminUserRemove                                                                                                                                                                                                                                                                                                                                 |
|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **НАЗВА:**             | Видалення облікового запису                                                                                                                                                                                                                                                                                                           |
| **УЧАСНИКИ:**          | Адміністратор, користувач, система                                                                                                                                                                                                                                                                                                     |
| **ПЕРЕДУМОВИ:**        | Користувач має обліковий запис                                                                                                                                                                                                                                                                                 |
| **РЕЗУЛЬТАТ:**         | Обліковий запис видалено                                                                                                                                                                                                                                                                                        |
| **ВИКЛЮЧНІ СИТУАЦІЇ:** | Користувач не має облікового запису - NoAccountError                                                                                                                                                                                                             |
| **ОСНОВНИЙ СЦЕНАРІЙ:** | 1. Адміністратор обирає користувача та відкриває сторінку з інструментами для роботи з ним <br/> 2. Система виводить інформацію облікового запису та інстументи для роботи з ним <br/> 3. Адміністратор натискає кнопку "Видалити обліковий запис" <br/> 4. Система видаляє обліковий запис та інформацію про нього <br/> 5. Система інформує адміністратора про успішне видалення та перенаправляє його на головну сторінку |

---



