# Cronometro

## About Project

* Criação de um cronômetro em Verilog

* O cronômetro será configurado de modo a exibir os segundos e décimos de segundos, partindo de 0,0 até 999,9.

* Considerando a sequência de contagem do cronômetro, optou-se pela montagem com módulos em cascata, que interligados operam como o cronometro desejado. São quatro registradores que incrementam sua contagem a cada ciclo completo (contar até 9) do registrador anterior.

* O cronometro possui quatro botões básicos, sendo eles: Reset, Contar, Pausar e Parar. Para ativar a ação dos botões é necessário que o usuário pressione e solte o mesmo, caso fique com o botão pressionado, nada deverá ocorrer.

* O sistema deve sempre iniciar com no estado Reset.

* No código Key 3 se refere ao botão Reset, Key 2 ao botão Contar, Key 1 ao botão Pausar e Key 0 ao botão Parar.


## Special Cases

* Ao soltar o botão Reset o circuito deve Resetar a contagem.
* Ao soltar o botão Contar o circuito deve iniciar a contagem.
* Ao soltar o botão Pausar o circuito deve pausar a contagem no display e continuar "contando em background".
* Ao soltar o botão Pausar pela segunda vez o circuito deve retomar a contagem a partir do valor obtido durante a contagem em background.
* Ao soltar o botão Parar o circuito deve parar a contagem.
* Enquanto o cronometro estiver pausado, nada ocorrerá caso o botão Contar seja pressionado.


## Requirements

* Quartus Prime Lite
* verilog


## Development Setup

### Quartus Prime Lite

* Quartus Prime
* ModelSim-Intel FPGA Edition
* Cyclone IV device support
* Quartus Prime Help
* Quartus Prime Programmer and Tools
 
* [Quartus](https://fpgasoftware.intel.com/?edition=lite)


## References

* [Intel Quartus® Prime Software User Guides](https://www.intel.com/content/www/us/en/programmable/products/design-software/fpga-design/quartus-prime/user-guides.html)
* [Intel FPGA Software Installation and Licensing Manual](https://www.intel.com/content/www/us/en/programmable/documentation/esc1425946071433.html)