'use client'

import { title } from "@/components/primitives";
import { FeatureTask } from "@/models/FeatureTask";
import { TaskService } from "@/services/TaskService";
import { Accordion, AccordionItem, Avatar, Button, Chip, getKeyValue } from "@nextui-org/react";
import { useEffect, useState } from "react";
import { siteConfig } from "@/config/site";


export default function FeatureTasksPage() {

	const [featureTasks, setFeatureTasks] = useState<FeatureTask[]>([]);
	const [indice, setIndice] = useState(0);
	
	useEffect(() => {
		TaskService.getAllFeatureTasks().then((response) => {
			setFeatureTasks(response);
		});
	}, [indice]);

	const handleDelete = (id: number) => {
		TaskService.deleteTask(id).catch((error) => {
			console.error("Error deleting feature task:", error);
		});
		setIndice((prevIndice) => prevIndice + 1);			
	};

	return (
		<div>
			<h1 className={`${title()} py-5`}>Feature Tasks</h1>
			{featureTasks.length > 0 ? (
				<Accordion variant="splitted" disabledKeys={["2"]}>
					{featureTasks.map((featureTask) => (
						<AccordionItem
							key={featureTask.id}
							startContent={
								<Avatar
									className="bg-transparent"
									radius="md"
									src="/assets/feature.svg"
								/>
							}
							aria-label={featureTask.name}
							subtitle={ <Chip variant="flat" color={getKeyValue(siteConfig.status, featureTask.status).color}> {getKeyValue(siteConfig.status, featureTask.status).name} </Chip>}
							title={
								<div className="flex justify-between items-center">
									<h1>{featureTask.name}</h1>
									<Avatar
										className="bg-transparent"
										radius="sm"
										src={getKeyValue(siteConfig.priorities, featureTask.priority).icon}
									/>
								</div>
								}

						>
							
							<div>
								<h1 className="font-bold text-2xl">{featureTask.name}</h1>
								<p>{featureTask.description}</p>
								<small>{featureTask.createdAt && 'Created at ' + featureTask.createdAt.toLocaleString()}</small>
							</div>

							<div className="flex justify-end items-center gap-2">
								<Button onClick={() => handleDelete(featureTask.id)} className="text-tiny" variant="flat" color="danger" radius="lg" size="sm">
									delete
								</Button>
								<Button className="text-tiny" variant="flat" color="default" radius="lg" size="sm">
									Open task
								</Button>

								{/* {featureTask.project &&
									(
										<Chip
											variant="flat"
											color="primary"
										>
											{featureTask.project.name}
										</Chip>
									)
								}

								{featureTask.assignedTo &&
									(
										<Chip
											variant="flat"
											color="secondary"
										>
											{'Assigned To ' + featureTask.assignedTo.firstName + ' ' + featureTask.assignedTo.lastName}
										</Chip>
									)
								} */}
							</div>
						</AccordionItem>
					))}
				</Accordion>
			) : (
				<p>No feature tasks available</p>
			)}
		</div>
	);
}