# Spring-nextjs-template
🚀 Modern Full-Stack Monorepo Template: Spring Boot 3.4 + React 19 + Open Liberty. Features end-to-end type safety (Java Records to TS), LGTM Observability stack, Playwright E2E, and Open Liberty InstantOn for sub-second cold starts.

# 🏛️ Enterprise Full-Stack Monorepo Template (2026)

[![Java Support](https://img.shields.io/badge/Java-21+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react&logoColor=black)](https://react.dev/)
[![Open Liberty](https://img.shields.io/badge/Open_Liberty-Fast-3D5A80?style=for-the-badge&logo=ibm&logoColor=white)](https://openliberty.io/)

A production-grade, cloud-native template designed for high-velocity teams. This monorepo bridges the gap between **Spring Boot's** enterprise reliability and **React 19's** modern UI capabilities, all running on the highly efficient **Open Liberty** runtime.



## ✨ Key Features

- **🛡️ Full-Stack Type Safety**: Shared Java Records in `libs/shared-dtos` are automatically synchronized to TypeScript interfaces in the frontend.
- **⚡ InstantOn Ready**: Pre-configured for Open Liberty's CRIU support, achieving <200ms startup times.
- **🔭 LGTM Observability**: Integrated OpenTelemetry tracing. View logs (Loki), traces (Tempo), and metrics (Mimir) in a pre-configured Grafana dashboard.
- **🧪 Modern Testing**: Integration tests powered by **Testcontainers** and E2E flows via **Playwright**.
- **📦 Optimized Monorepo**: Managed via **pnpm workspaces** (frontend) and **Maven Multi-Module** (backend).

## 📁 Repository Structure

```text
├── apps/
│   ├── api-backend/      # Spring Boot 3.4 + Open Liberty
│   └── web-frontend/     # Nextjs
├── libs/
│   ├── shared-dtos/      # Shared Java Records & TS Definitions
│   └── ui-core/          # Shared Tailwind v4 + Shadcn/UI
├── observability/        # Grafana, Loki, Tempo, Mimir Configs
└── docker/               # Multi-stage Dockerfiles
