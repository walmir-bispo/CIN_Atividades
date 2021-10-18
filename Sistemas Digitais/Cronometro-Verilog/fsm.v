module fsm(clock, key3,key2,key1,key0,out0,out1,out2,out3);

	input clock, key3,key2,key1,key0 ;
	reg[1:0] estado_atual, prox_estado;
	reg key_reset,key_contar,key_pausar,key_parar;
	reg aux3,aux2,aux1,aux0;
	output reg [3:0] out0,out1,out2,out3;
	reg [3:0] cont0,cont1,cont2,cont3;
	
	
	reg [3:0] aux_pausa0,aux_pausa1,aux_pausa2,aux_pausa3, aux_para0,aux_para1,aux_para2,aux_para3;
	
	parameter reset=2'd0, contar=2'd1, pausar=2'd2, parar=2'd3;
	
	initial begin
		prox_estado=2'd0;
		estado_atual=2'd0;
		out0=4'd0;
		out1=4'd0;
		out2=4'd0;
		out3=4'd0;
	end
	
	always@(posedge clock)begin
		
		if(estado_atual==contar && prox_estado==pausar)begin
			aux_pausa0=cont0;
			aux_pausa1=cont1;
			aux_pausa2=cont2;
			aux_pausa3=cont3;
		end
		
		if(prox_estado==parar)begin	
			if(estado_atual==contar)begin
				aux_para0=cont0;
				aux_para1=cont1;
				aux_para2=cont2;
				aux_para3=cont3;
				
			end else if(estado_atual==pausar)begin
				
				aux_para0=aux_pausa0;
				aux_para1=aux_pausa1;
				aux_para2=aux_pausa2;
				aux_para3=aux_pausa3;
				
			end else if(estado_atual==reset)begin
				aux_para0=4'b0000;
				aux_para1=4'b0000;
				aux_para2=4'b0000;
				aux_para3=4'b0000;
			end
			
		end
		
		
		if(estado_atual==parar && prox_estado==contar)begin
			cont0=aux_para0;
			cont1=aux_para1;
			cont2=aux_para2;
			cont3=aux_para3;
		end
		
		estado_atual=prox_estado;
		
		
		if(estado_atual==contar || estado_atual==pausar)begin
		
			if(cont0==4'b1001)begin
				cont0=4'b0000;
			
				if(cont1==4'b1001)begin
					cont1=4'b0000;
				
					if(cont2==4'b1001)begin
						cont2=4'b0000;
					
						if(cont3==4'b1001)begin
							cont3=4'b0000;
							
						end else begin
							cont3=cont3+4'd1;
						end
						
						
					end else begin 
						cont2=cont2+4'd1;
					end
					
				end else begin
					cont1=cont1+4'd1;
				end
				
			end else begin
				cont0=cont0+4'd1;
			end
	
		end else begin
			cont0=0;
			cont1=0;
			cont2=0;
			cont3=0;
		end
	
	end
	
	
	
	
	always @(*)begin
		
		if(key_reset)begin
			prox_estado=reset;
			aux3=1;
			
		end else begin
			prox_estado=prox_estado;
			aux3=0;		
		end
		
		
		if(key_contar)begin
		
			if(estado_atual==pausar)begin
				prox_estado=pausar;
				
			end else begin
				prox_estado=contar;
			end
			
			aux2=1;
			
		end else begin
			prox_estado=prox_estado;
			aux2=0;
		end
		
		
		if(key_pausar)begin
			
			if(estado_atual==contar)begin
				prox_estado=pausar;
				aux1=1;
				
			end else if(estado_atual==pausar)begin
				prox_estado=contar;
				aux1=1;
				
			end else begin //estado atual == parar ou == reset
				prox_estado=estado_atual;
				aux1=1;
			end
			
		end else begin		
			prox_estado=prox_estado;
			aux1=0;
		end
		
		
		
		if(key_parar)begin
			prox_estado=parar;
			aux0=1;
			
		end else begin
			aux0=0;
			prox_estado=prox_estado;
		end
	
		
		
		
		case(estado_atual)
			reset: begin
				
				out0=4'd0;
				out1=4'd0;
				out2=4'd0;
				out3=4'd0;
				
			end
			contar: begin
			
				
				out0=cont0;
				out1=cont1;
				out2=cont2;
				out3=cont3;
				
			
			end
			pausar: begin
				
				out0=aux_pausa0;
				out1=aux_pausa1;
				out2=aux_pausa2;
				out3=aux_pausa3;
		
			end
			parar: begin
				
				out0=aux_para0;
				out1=aux_para1;
				out2=aux_para2;
				out3=aux_para3;
				
			end
		endcase
	
	
	end
	
	
	
	
	
	
	
	always @(posedge key3 or posedge aux3)begin
	
		if(aux3)begin //esse aux só vai servir pra dizer quando o key 3 tem q voltar pra 0
			key_reset=0; 
		
		end else begin	
			key_reset=1;	
		end
		
	end
	
	
	always @(posedge key2 or posedge aux2)begin
	
		if(aux2)begin //esse aux só vai servir pra dizer quando o key 2 tem q voltar pra 0
			key_contar=0; 
		
		end else begin		
			key_contar=1;	
		end
		
	end
	
	
	
	always @(posedge key1 or posedge aux1)begin
	
		if(aux1)begin //esse aux só vai servir pra dizer quando o key 1 tem q voltar pra 0
			key_pausar=0;
			
		end else begin	
			key_pausar=1;
		
		end

	end
	
	
	
	always @(posedge key0 or posedge aux0)begin
	
		if(aux0)begin //esse aux só vai servir pra dizer quando o key 0 tem q voltar pra 0
			key_parar=0; 
			
		end else begin		
			key_parar=1;		
		end
	end
	
	
endmodule 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	