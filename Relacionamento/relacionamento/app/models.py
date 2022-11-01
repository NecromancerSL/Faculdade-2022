from django.db import models

class Marca(models.Model):
    nome = models.CharField(max_length=20, null=False)

class Produto(models.Model):
    descricao = models.CharField(max_length=50, null=False)
    preco = models.FloatField(null=False)
    marca = models.ForeignKey(Marca, on_delete=models.PROTECT)