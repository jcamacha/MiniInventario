# SKILL 01 — Metodología del Orquestador
# IT Project Manager & Chief Architect

Esta skill define el proceso completo que el Orquestador debe seguir
desde la recepción de requerimientos hasta la entrega del sistema.
**Sigue los pasos en orden estricto. No avances sin completar el anterior.**

---

## FASE 0 — RECEPCIÓN Y CLASIFICACIÓN (siempre primero)

### 0.1 Determina el tipo de entrada

**Caso A — Proyecto nuevo:**
Recibes una descripción de requerimientos en texto libre.
Continúa con la FASE 1.

**Caso B — Sistema existente (migración/refactorización):**
Recibes código, fragmentos, o un `LEGACY_HANDOFF.md` de un sistema anterior.
→ **Invoca primero al Subagente E (Analista Legacy)** para que genere el
`LEGACY_HANDOFF.md` si no existe ya.
→ Cuando el `LEGACY_HANDOFF.md` esté disponible, continúa con la FASE 1
usando ese documento como input adicional de requerimientos.

### 0.2 Determina los MCPs necesarios

Antes de continuar, evalúa qué herramientas externas necesita el proyecto
y solicita al usuario que las conecte si no están disponibles. Ejemplos:

| Si el proyecto necesita...     | Solicita MCP...                          |
|-------------------------------|------------------------------------------|
| Base de datos Supabase         | `@supabase/mcp-server-supabase`          |
| PostgreSQL local               | `mcp-server-postgres`                    |
| Investigación web              | `@modelcontextprotocol/server-brave-search` |
| Razonamiento estructurado      | `@modelcontextprotocol/server-sequential-thinking` |
| GitHub / control de versiones  | `@modelcontextprotocol/server-github`    |
| Docker / contenedores          | MCP correspondiente                      |

**Pausa aquí. Muestra al usuario la lista de MCPs necesarios y espera
confirmación antes de continuar.**

---

## FASE 1 — DISCOVERY (análisis y aclaración)

### 1.1 Extrae los requerimientos

Lee la descripción del sistema e identifica:

```
REQUERIMIENTOS FUNCIONALES:     ¿Qué debe HACER el sistema?
REQUERIMIENTOS NO FUNCIONALES:  ¿Rendimiento, seguridad, escalabilidad?
USUARIOS DEL SISTEMA:           ¿Quién lo usa y cómo?
INTEGRACIONES EXTERNAS:         ¿APIs de terceros, servicios externos?
RESTRICCIONES TÉCNICAS:         ¿Lenguaje obligatorio, plataforma, presupuesto?
CRITERIO DE ÉXITO:              ¿Cómo sabemos que está "terminado"?
```

### 1.2 Formula preguntas críticas

Identifica las ambigüedades que impedirían tomar decisiones arquitectónicas.
Clasifícalas por impacto:

- **[BLOQUEANTE]** — No puedo avanzar sin esta respuesta
- **[IMPORTANTE]** — Afecta el diseño pero puedo asumir un default razonable
- **[MENOR]** — Se puede decidir durante la implementación

Presenta SOLO las preguntas BLOQUEANTES al usuario en este momento.
**Pausa y espera respuesta antes de continuar.**

### 1.3 Documenta los supuestos

Para las preguntas IMPORTANTES que no esperarás, documenta el supuesto que
asumirás y por qué. Estos van en el `DEV_JOURNAL_ADR.md` como `SUPUESTO-N`.

---

## FASE 2 — ARQUITECTURA Y BLUEPRINT

### 2.1 Investiga el stack óptimo

Usa el MCP de búsqueda web para investigar:
- Mejores prácticas 2025-2026 para el tipo de sistema
- Comparativas de frameworks relevantes
- Problemas conocidos de las opciones consideradas

### 2.2 Determina la tipología del sistema

Clasifica el proyecto en una o más de estas categorías para saber
qué subagentes instanciar:

| Tipología              | Subagentes requeridos          |
|------------------------|-------------------------------|
| API REST/GraphQL pura  | A (Backend) + D (QA)          |
| Web full-stack         | A (Backend) + B (Frontend) + D (QA) |
| Pipeline de datos / ML | C (Datos) + D (QA)            |
| Sistema con IA         | A (Backend) + C (Datos) + D (QA) |
| CLI / herramienta      | A (Backend) + D (QA)          |
| Migración/refactor     | E (Legacy) + [los que apliquen] |
| Microservicios         | A por cada servicio + D (QA)  |

### 2.3 Crea el DEV_JOURNAL_ADR.md

Crea el archivo en la raíz del proyecto con esta estructura inicial:

```markdown
# DEV_JOURNAL_ADR — [Nombre del Sistema]
Proyecto iniciado: [fecha]
Orquestador: agy Software Factory v2.0

---

## RESUMEN EJECUTIVO
[2-3 párrafos describiendo qué es el sistema y qué problema resuelve]

## STACK TECNOLÓGICO ELEGIDO
| Capa          | Tecnología    | Razón de la elección            |
|---------------|---------------|---------------------------------|
| Backend       |               |                                 |
| Base de datos |               |                                 |
| Frontend      |               |                                 |
| Infraestructura|              |                                 |

## ARQUITECTURA DEL SISTEMA
[Descripción textual de la arquitectura. Incluye diagrama ASCII si aplica]

## MODELO DE DATOS
[Entidades principales y sus relaciones]

## CONTRATOS DE API
[Endpoints principales con método, ruta, input y output esperado]

## SUPUESTOS TOMADOS
- SUPUESTO-1: [descripción y razón]

## REGISTRO DE DECISIONES ARQUITECTÓNICAS (ADR)

### ADR-001: [Título de la decisión]
- Fecha: [fecha]
- Estado: APROBADA
- Contexto: [por qué se tomó esta decisión]
- Decisión: [qué se decidió]
- Consecuencias: [qué implica esta decisión]

## REGISTRO DE SPRINTS
[Se irá llenando conforme avance el proyecto]

## REGISTRO DE PROBLEMAS
[Se irá llenando cuando surjan problemas]
```

### 2.4 Genera la estructura de directorios

Crea físicamente la estructura de carpetas vacía del proyecto con un
`README.md` mínimo en la raíz.

### 2.5 Presenta el blueprint al usuario

Muestra un resumen de:
- Stack elegido con justificación
- Subagentes que instanciarás
- Estructura de carpetas
- Plan de sprints en orden

**Pausa. Espera aprobación del usuario antes de continuar.**

---

## FASE 3 — BOOTSTRAPPING (preparación de subagentes)

### 3.1 Crea las skills locales de los subagentes

En `.agents/skills/`, crea los archivos de reglas específicas del proyecto
para cada subagente que instanciarás. Basa su contenido en:
- El stack tecnológico elegido
- Las convenciones del proyecto (nombres, estructura, estilo de código)
- Los contratos de API definidos
- Las restricciones de negocio

Nomenclatura: `subagente_[letra]_[nombre_tecnologia].md`
Ejemplo: `subagente_a_fastapi_postgresql.md`

### 3.2 Instala dependencias base

Ejecuta los comandos de inicialización del proyecto:
- `npm init`, `poetry init`, `cargo init`, etc.
- Instala dependencias globales del proyecto
- Configura linters y formateadores

### 3.3 Configura el control de versiones

```bash
git init
# Crea .gitignore apropiado para el stack
git add .
git commit -m "chore: initial project structure by Software Factory Orchestrator"
```

---

## FASE 4 — EJECUCIÓN POR SPRINTS

### 4.1 Protocolo de delegación

Para cada sprint, sigue este ciclo sin excepciones:

```
1. Redacta el SPRINT_BRIEF para el subagente correspondiente
2. Invoca al subagente con el brief
3. Espera su SPRINT_REPORT completo
4. Si ESTADO = DONE:
     → Actualiza DEV_JOURNAL_ADR.md con el sprint completado
     → Invoca al Subagente D (QA) para verificar
     → Si QA pasa: avanza al siguiente sprint
     → Si QA falla: analiza el log, decide si reenvías al mismo subagente
       o cambias el diseño, registra en ADR
5. Si ESTADO = BLOQUEADO:
     → Analiza el problema
     → Si es un cambio de diseño: registra nuevo ADR, ajusta el blueprint
     → Reenvía al subagente con el brief corregido
6. Si ESTADO = PARCIAL:
     → Evalúa si lo parcial es suficiente para continuar
     → Registra la deuda técnica en DEV_JOURNAL_ADR.md
```

### 4.2 Orden de sprints recomendado

```
Sprint 0: Infraestructura base (DB schema, variables de entorno, Docker si aplica)
Sprint 1: Núcleo de la lógica de negocio (modelos, servicios)
Sprint 2: Capa de API / endpoints
Sprint 3: QA de backend completo
Sprint 4: Frontend / UI (si aplica)
Sprint 5: Integración end-to-end
Sprint 6: QA final y hardening
```

Ajusta el orden según la tipología del proyecto.

### 4.3 Actualización del journal

Después de cada sprint completado, agrega al `DEV_JOURNAL_ADR.md`:

```markdown
### Sprint [N]: [Nombre] — [COMPLETADO / PARCIAL / FALLIDO]
Fecha: [fecha]
Subagente: [letra y nombre]
Archivos producidos: [lista]
Decisiones tomadas: [cambios respecto al brief]
Problemas encontrados: [si los hubo]
Deuda técnica registrada: [si aplica]
```

---

## FASE 5 — CIERRE Y ENTREGA

### 5.1 Verificación final

Invoca al Subagente D (QA) para ejecutar el suite de tests completo.
Verifica que el sistema cumple los criterios de éxito definidos en el DISCOVERY.

### 5.2 Cierre del DEV_JOURNAL_ADR.md

Agrega al final del journal:

```markdown
---
## CIERRE DEL PROYECTO
Fecha de cierre: [fecha]
Estado: [ENTREGADO / ENTREGADO CON DEUDA TÉCNICA]

### Funcionalidades entregadas
[Lista de lo que funciona]

### Deuda técnica pendiente
[Lista de lo que quedó pendiente con razón]

### Lecciones aprendidas
[Para el registro histórico]

### Para el Agente LaTeX
Este journal contiene toda la información necesaria para generar
la documentación final del sistema. Las secciones relevantes son:
- RESUMEN EJECUTIVO → para la introducción del reporte
- STACK TECNOLÓGICO → para la sección de desarrollo
- REGISTRO DE DECISIONES ADR → para justificar elecciones de diseño
- REGISTRO DE SPRINTS → para la sección de desarrollo paso a paso
- REGISTRO DE PROBLEMAS → para la sección de conclusiones
```

### 5.3 Commit final

```bash
git add .
git commit -m "feat: system delivery — see DEV_JOURNAL_ADR.md for details"
```
