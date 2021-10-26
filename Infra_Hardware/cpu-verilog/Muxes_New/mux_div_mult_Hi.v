module mux_div_mult_Hi (
    input wire selector,
    input wire [31:0] data_0,
    input wire [31:0] data_1,
    output wire [31:0] Data_out
);
    assign Data_out = (selector) ? data_1 : data_0;
    
endmodule
