# Requisitos No Funcionales (RNF)
> **Atributos de calidad y restricciones técnicas que garantizan la viabilidad de Enlace Pro.**

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


|  ID |  Atributo de Calidad |  Descripción Técnica | 
| :---: | :--- | :--- |
| **NF1** | **Usabilidad / UX** | El acceso a la traducción debe ser sencillo (ej. al pasar el ratón, efecto flashcard...). |
| **NF2** | **Eficiencia (Traducción)** | Para ahorrar tiempo, la traducción debe implementarse mediante una API externa (ej. Google AI Studio o similar) para realizar traducciones en tiempo real, sin guardar las traducciones en la DB. | 
| **NF3** | **Simplicidad (Nivel)** | Para ahorrar tiempo y complejidad, el modelo de nivel será simplificado a un Modelo Nivel (Bajo, Medio, Alto), en lugar de un examen MCER completo o algoritmos de IA complejos. | 
| **NF4** | **Rendimiento** | El sistema debe realizar la llamada al servicio externo de traducción de manera rápida para evitar latencia al solicitar la traducción. |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### ⚙️ Decisiones de Arquitectura Relacionadas
Para cumplir con estos requisitos, el sistema se apoya en:
* 🎨 **CSS Dinámico:** Uso de Tailwind para los efectos de hover y transiciones suaves (**NF1**).



