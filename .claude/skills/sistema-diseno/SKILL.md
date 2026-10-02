---
name: sistema-diseno
description: Sistema de diseño UI del proyecto (tokens de color, tipografía, espaciado, componentes, patrones de pantalla y reglas de accesibilidad) para el panel administrativo y el portal de padres. Úsala al crear o revisar cualquier pantalla, plantilla Thymeleaf o CSS.
---

# Sistema de diseño

## Personalidad
**Confiable, claro y cercano.** Es un sistema que maneja el dinero de las familias y la información de sus hijos, así que debe transmitir orden y transparencia. Nada recargado.

## Tokens (CSS custom properties)
Defínelos una sola vez en `static/css/tokens.css` y úsalos siempre.
```css
:root {
  /* Marca (reemplazar por los colores del colegio) */
  --color-primario: #1d4ed8;
  --color-primario-hover: #1e40af;
  --color-primario-suave: #dbeafe;

  /* Neutros */
  --color-fondo: #f8fafc;
  --color-superficie: #ffffff;
  --color-borde: #e2e8f0;
  --color-texto: #0f172a;
  --color-texto-secundario: #475569;

  /* Estados (siempre acompañados de texto o ícono) */
  --color-exito: #15803d;      --color-exito-suave: #dcfce7;    /* Pagado */
  --color-alerta: #b45309;     --color-alerta-suave: #fef3c7;   /* Pendiente o por vencer */
  --color-peligro: #b91c1c;    --color-peligro-suave: #fee2e2;  /* Vencido o anulado */
  --color-info: #0369a1;       --color-info-suave: #e0f2fe;

  /* Tipografía */
  --fuente: "Inter", system-ui, -apple-system, "Segoe UI", Roboto, sans-serif;
  --texto-xs: 0.75rem; --texto-sm: 0.875rem; --texto-base: 1rem;
  --texto-lg: 1.125rem; --texto-xl: 1.5rem; --texto-2xl: 2rem;

  /* Espaciado (escala de 4 px) */
  --esp-1: 4px; --esp-2: 8px; --esp-3: 12px; --esp-4: 16px;
  --esp-6: 24px; --esp-8: 32px; --esp-12: 48px;

  --radio: 8px;
  --sombra: 0 1px 3px rgb(15 23 42 / 0.08);
}
```
Los textos de estado sobre fondos suaves cumplen un contraste AA. Valida cualquier color nuevo con una herramienta de contraste.

## Componentes base (fragmentos Thymeleaf en `templates/fragments/`)
| Componente | Uso | Reglas |
|---|---|---|
| `layout` | Estructura de página | Menú lateral en escritorio, barra inferior en celular. Muestra colegio, usuario y rol. |
| `boton` | Acciones | Variantes: primario (1 por pantalla), secundario, peligro y texto. Altura mínima de 44 px. |
| `campo` | Inputs | `<label>` siempre visible (el placeholder no la reemplaza). Ayuda y error debajo del campo. |
| `tabla` | Listados | Encabezado fijo, montos alineados a la derecha, en celular se convierte en tarjetas. |
| `badge-estado` | Estado de cuota o pago | Color más texto: **Pagado**, **Pendiente**, **Vencido**, **Anulado**. |
| `monto` | Mostrar dinero | `S/ 1,250.00`, números tabulares (`font-variant-numeric: tabular-nums`). |
| `alerta` | Mensajes | Éxito, info, advertencia y error, con ícono y texto. `role="alert"` para los errores. |
| `modal-confirmacion` | Acciones sensibles | Título claro, consecuencia explicada, **motivo obligatorio** para anular o descontar y botón de peligro. |
| `tarjeta-kpi` | Panel del dueño | Cifra grande, etiqueta y comparación ("vs. ayer"). |
| `estado-vacio` | Listas vacías | Explicación y acción siguiente. |

## Patrones de pantalla clave
- **Caja (cajero)**: buscar alumno (por DNI, nombre o código) → ver cuotas pendientes → seleccionar → elegir medio de pago → confirmar → comprobante emitido y padre notificado (mostrar ambos como confirmación).
- **Estado de cuenta (padre, celular)**: total pendiente arriba y destacado, botón "Pagar ahora", lista de cuotas con badge y historial de comprobantes descargables.
- **Panel del dueño (celular)**: recaudado hoy, del mes, morosidad en % y en S/, alertas de caja con diferencia y pendientes de aprobación.
- **Aprobaciones (director)**: bandeja con quién solicita, qué, monto y motivo, y los botones Aprobar o Rechazar con comentario.

## Accesibilidad (WCAG 2.1 AA, obligatorio)
- Contraste de 4.5:1 en texto normal y 3:1 en texto grande y elementos de interfaz.
- Foco visible en todos los elementos interactivos (`:focus-visible`).
- Navegable por teclado y en orden lógico.
- Nunca transmitir información solo con color.
- `lang="es"` en el `<html>` e imágenes con `alt`.
- Objetivos táctiles de al menos 44×44 px.

## Lenguaje
Español claro, en segunda persona ("tu pago", "tus cuotas"). Sin jerga técnica. Botones con verbo de acción: "Registrar pago", no "Aceptar".
