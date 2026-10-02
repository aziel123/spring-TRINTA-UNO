# Sistema de gestión escolar

Plataforma para modernizar un colegio privado del Perú. El primer módulo es **cobranza con controles antifraude**: el colegio perdió más de S/ 70,000 por falta de control en los cobros. Después vienen el módulo académico (notas, asistencia, SIAGIE) y el de comunicación con los padres.

## Stack
Spring Boot 2.6 · Java 11 · Spring Data JPA · Thymeleaf · MySQL · Maven (`./mvnw`).
Paquete base: `edu.pe.idat.app`.

## Comandos
- Compilar: `./mvnw -q compile`
- Pruebas: `./mvnw test`
- Ejecutar: `./mvnw spring-boot:run`

## Skills del proyecto (`.claude/skills/`)
- `contexto-colegio`: dominio, actores, glosario, **reglas antifraude obligatorias** y normativa. Cárgala siempre.
- `crear-modulo-spring`: convenciones de backend (paquetes, capas, dinero, auditoría, pruebas).
- `sistema-diseno`: tokens, componentes, patrones de pantalla y accesibilidad.
- `evaluacion-ux`: entrevistas, personas, journey maps, heurísticas, pruebas de usabilidad y métricas.

## Agentes del proyecto (`.claude/agents/`)
| Agente | Cuándo usarlo |
|---|---|
| `arquitecto-software` | Antes de codear un módulo: modelo de datos y plan |
| `backend-spring` | Implementar entidades, servicios, controladores y pruebas |
| `qa-tester` | Diseñar y escribir los casos de prueba |
| `auditor-seguridad-antifraude` | Revisar todo cambio que toque dinero, roles o datos de alumnos |
| `disenador-ui` | Diseñar o revisar pantallas y plantillas Thymeleaf |
| `investigador-ux` | Entrevistas, personas, flujos, usabilidad y microcopy |

Flujo sugerido para una funcionalidad: `investigador-ux` → `arquitecto-software` → `disenador-ui` → `backend-spring` → `qa-tester` → `auditor-seguridad-antifraude`.

## Reglas no negociables
- Dinero siempre en `BigDecimal` (escala 2). Nunca `double`.
- Los pagos y las cuotas no se borran ni se editan: se anulan con motivo y aprobación.
- Toda operación financiera queda en la auditoría inmutable.
- Toda entidad de negocio lleva `colegioId` y toda consulta filtra por él.
- Quien cobra no aprueba (segregación de funciones).
