# 🔐 UserAccess UI

A responsive front-end authentication interface built with HTML, CSS, and JavaScript. Includes login, registration, and password recovery pages. Designed as a self-practice project to understand user input flows, form validation, and basic UI automation.

---

🌐 **Live Demo**

- [🔑 Login Page](https://pratiks-desk.site/user-access-ui/login.html)  
- [📝 Register Page](https://pratiks-desk.site/user-access-ui/register.html)  
- [🔁 Forgot Password Page](https://pratiks-desk.site/user-access-ui/forgot-password.html)

---

## 📌 Features

- 🔐 **Login Form**
  - Email/password fields with validation
  - Clean layout with hover effects

- 📝 **Registration Form**
  - Name, email, password, confirm password
  - HTML5 + JavaScript validation

- ❓ **Forgot Password**
  - Enter email to receive reset link (mock)

- ⚠️ **Alert Feedback**
  - Alerts shown for success, error, and validation

---

## 🧪 QA Artifacts (Embedded)

Each HTML page includes:

- ✅ Test Plan  
- 🧾 Test Scenarios  
- 🔍 Test Cases Table

### 📋 Sample Test Cases

| TC ID   | Feature           | Step Description                     | Expected Result                     |
|---------|-------------------|--------------------------------------|-------------------------------------|
| TC006   | Form Alerts       | Submit forms with incomplete data    | Appropriate alert is shown          |
| TC007   | Navigation        | Click "Forgot Password" on login     | Redirects to Forgot Password page   |
| TC101   | Login             | Valid email & password               | Success alert shown                 |
| TC103   | Login             | Empty email                          | Alert: Email is required            |
| TC105   | Register          | Password mismatch                    | Alert: Passwords do not match       |
| TC202   | Forgot Password   | Empty email                          | Alert: Email is required            |
| TC203   | Forgot Password   | Invalid email format                 | Alert: Invalid email format         |

---

## 🛠️ Tech Stack

- HTML5 + CSS3 (Responsive design)
- Vanilla JavaScript (Client-side validation)
- No backend — fully static

---

## 🤖 Selenium Automation (Java)

To automate UI testing:

- Page Classes:  
  `LoginPage.java`, `RegisterPage.java`, `ForgotPasswordPage.java`

- Test Classes:  
  `LoginTest.java`, `RegisterTest.java`, `ForgotPasswordTest.java`

- No frameworks required (TestNG/JUnit not used) — just basic Java + Selenium WebDriver.

```java
driver.get("https://pratiks-desk.site/user-access-ui/login.html");

```
## 🤝 Contributing

This is a self-practice project to demonstrate front-end design and QA/automation skills.

You're welcome to:
- Suggest better HTML/CSS structure
- Improve accessibility or UX
- Refactor JavaScript validations
- Submit issues or pull requests

Just fork the repo, make changes, and create a Pull Request. I’ll review it and we can improve the project together!

📢 All feedback and contributions are appreciated 🙏

---

## 👤 Author

**Pratik Joshi**

## 📃 License

This project is open for personal and educational use. No license applied.

---


