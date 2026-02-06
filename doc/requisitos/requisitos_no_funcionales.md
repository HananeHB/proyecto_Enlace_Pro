#### **Requisitos No Funcionales (NF)**

| ID | Requisitos No Funcionales | Descripción
|---|---|---|
|NF1| Usabilidad/UX    | El acceso a la traducción debe ser sencillo (ej. al pasar el ratón, efecto flashcard...).|
|NF2| Eficiencia de Desarrollo (Traducción)  |   Para ahorrar tiempo, la traducción debe implementarse mediante una **API externa** (ej. Google AI Studio o similar) para realizar traducciones en tiempo real, sin guardar las traducciones en la DB.     |
|NF3|  Eficiencia de Desarrollo (Adaptación) |  Para ahorrar tiempo y complejidad, el modelo de nivel será **simplificado** a un Modelo Nivel (**Bajo, Medio, Alto**), en lugar de un examen MCER completo o algoritmos de IA complejos.    |
|NF4|  Rendimiento (Traducción) | El sistema debe realizar la llamada al servicio externo de traducción de manera rápida para evitar latencia al solicitar la traducción.  |