# TODO
- gui for ventas
- I have todo the logic for finance
- make the client system
- refactor a little of code

# Productos

## Tablas:
- Producto: | Id | Nombre | Marca | Descripcion | Proveedor | Borrado |
  > [!Note]son los productos en general.
    - maquillage:
        bagues
        millanel
    - perfume:
        - bagues
        - millanel

    - masculino
    - femenino

- Stock: | Id | Id Productos | Fecha Compra | sellIt |

- Venta: | Id | Id Stock | Precio | Fecha |

- Inversion: | Id | Fecha | Monto | Descripcion |

- Funcionalidades:
    
    - Productos:
        - nuevo
        - modificar
        - eliminacionLogica
        - ver

    - Stock:
        - ver
        - buscar
        - ampliar

    - Ventas:
        - realizar
        - verGanancias (mes/dia/otros intervalos)
        - resumenFinanciero

    - Inversiones: 
        - ver

        
# Clientes

- Tablas:
    Clients: | name | surname | purchases | account |
